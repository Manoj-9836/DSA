class Solution {
    class DSU {
        int[] parent;
        
        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        
        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int minMandatory = Integer.MAX_VALUE;
        DSU checkCycle = new DSU(n);
        
        for (int[] edge : edges) {
            if (edge[3] == 1) {
                minMandatory = Math.min(minMandatory, edge[2]);
                if (!checkCycle.union(edge[0], edge[1])) {
                    return -1; 
                }
            }
        }
        
        int low = 1;
        int high = Math.min(200000, minMandatory);
        int maxStability = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canAchieve(mid, n, k, edges)) {
                maxStability = mid;
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }
        
        return maxStability;
    }

    private boolean canAchieve(int target, int n, int k, int[][] edges) {
        DSU dsu = new DSU(n);
        int components = n;
        
        for (int[] edge : edges) {
            if (edge[3] == 1) {
                if (dsu.union(edge[0], edge[1])) components--;
            }
        }
        
        for (int[] edge : edges) {
            if (edge[3] == 0 && edge[2] >= target) {
                if (dsu.union(edge[0], edge[1])) components--;
            }
        }
        
        int upgradesUsed = 0;
        for (int[] edge : edges) {
            if (edge[3] == 0 && edge[2] < target && 2 * edge[2] >= target) {
                if (dsu.union(edge[0], edge[1])) {
                    components--;
                    upgradesUsed++;
                }
            }
        }
        
        return components == 1 && upgradesUsed <= k;
    }
}