class Solution {
    public long maxScore(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        List<Integer> cycles = new ArrayList<>();
        List<Integer> chains = new ArrayList<>();

        // 1. Decompose the graph into cycles and chains
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] info = new int[2]; // info[0] = node count, info[1] = sum of degrees
                dfs(i, adj, visited, info);
                int nodes = info[0];
                int edgeCount = info[1] / 2;

                if (edgeCount == nodes) {
                    cycles.add(nodes);
                } else if (nodes > 1) {
                    // Single isolated nodes (nodes == 1) contribute 0 edges and get the smallest numbers last
                    chains.add(nodes);
                }
            }
        }

        // 2. Sort both lists in descending order of size
        cycles.sort(Collections.reverseOrder());
        chains.sort(Collections.reverseOrder());

        long totalScore = 0;
        long currentVal = n;

        // 3. Assign highest numbers to cycles first
        for (int k : cycles) {
            long low = currentVal - k + 1;
            totalScore += calculateComponentScore(low, currentVal, true);
            currentVal -= k;
        }

        // 4. Assign remaining highest numbers to chains
        for (int k : chains) {
            long low = currentVal - k + 1;
            totalScore += calculateComponentScore(low, currentVal, false);
            currentVal -= k;
        }

        return totalScore;
    }

    private void dfs(int u, List<List<Integer>> adj, boolean[] visited, int[] info) {
        visited[u] = true;
        info[0]++;
        info[1] += adj.get(u).size();
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited, info);
            }
        }
    }

    // Places values [low..high] in peak-in-middle order: ..., high-2, high, high-1, ...
    private long calculateComponentScore(long low, long high, boolean isCycle) {
        int k = (int) (high - low + 1);
        long[] order = new long[k];
        int left = 0, right = k - 1;
        long val = low;

        // Fill from the outside ends inward with smallest values first
        while (left <= right) {
            order[left++] = val++;
            if (left <= right) {
                order[right--] = val++;
            }
        }

        long score = 0;
        for (int i = 0; i < k - 1; i++) {
            score += order[i] * order[i + 1];
        }
        if (isCycle) {
            score += order[0] * order[k - 1];
        }
        return score;
    }
}