class Solution {
    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        
        dfs(0, -1, vis, adj, tin, low, bridges);
        return bridges;
    }

    private void dfs(int node, int parent, boolean[] vis, List<List<Integer>> adj, int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = true;
        tin[node] = low[node] = timer++;
        
        for (Integer it : adj.get(node)) {
            if (it == parent) continue;
            if (vis[it]) {
                low[node] = Math.min(low[node], tin[it]);
            } else {
                dfs(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(node, it));
                }
            }
        }
    }
}