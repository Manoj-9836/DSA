class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1000000007;
        
        int[][][] dp = new int[zero + 1][one + 1][2];
        
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }
        
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                
                long sum0 = 0;
                for (int L = 1; L <= Math.min(i, limit); L++) {
                    sum0 = (sum0 + dp[i - L][j][1]) % MOD;
                }
                dp[i][j][0] = (int) sum0;
                
                long sum1 = 0;
                for (int L = 1; L <= Math.min(j, limit); L++) {
                    sum1 = (sum1 + dp[i][j - L][0]) % MOD;
                }
                dp[i][j][1] = (int) sum1;
            }
        }
        
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}