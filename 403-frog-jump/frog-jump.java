class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        
        if (n >= 2 && stones[1] != 1) {
            return false;
        }
        boolean[][] dp = new boolean[n][n + 1];
        
        dp[0][0] = true;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int jumpSize = stones[i] - stones[j];
                
                if (jumpSize > j + 1) {
                    continue;
                }
                
                if (dp[j][jumpSize - 1] || dp[j][jumpSize] || dp[j][jumpSize + 1]) {
                    dp[i][jumpSize] = true;
                    
                    if (i == n - 1) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}