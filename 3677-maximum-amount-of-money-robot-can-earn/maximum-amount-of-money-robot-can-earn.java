class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        
        int INF = Integer.MIN_VALUE / 2; 

        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = dp[i][2] = INF;
        }

        for (int i = 0; i < m; i++) {
            int[][] nextDp = new int[n][3];
            for (int j = 0; j < n; j++) {
                nextDp[j][0] = nextDp[j][1] = nextDp[j][2] = INF;
            }

            for (int j = 0; j < n; j++) {
                int val = coins[i][j];
                int nVal = val < 0 ? 0 : val; 

                if (i == 0 && j == 0) {
                    nextDp[0][0] = val;
                    nextDp[0][1] = nVal;
                    nextDp[0][2] = nVal;
                    continue;
                }

                for (int k = 0; k < 3; k++) {
                    if (i > 0 && dp[j][k] != INF) {
                        nextDp[j][k] = Math.max(nextDp[j][k], dp[j][k] + val);
                    }
                    if (j > 0 && nextDp[j - 1][k] != INF) {
                        nextDp[j][k] = Math.max(nextDp[j][k], nextDp[j - 1][k] + val);
                    }

                    if (k > 0) {
                        if (i > 0 && dp[j][k - 1] != INF) {
                            nextDp[j][k] = Math.max(nextDp[j][k], dp[j][k - 1] + nVal); 
                        }
                        if (j > 0 && nextDp[j - 1][k - 1] != INF) {
                            nextDp[j][k] = Math.max(nextDp[j][k], nextDp[j - 1][k - 1] + nVal); 
                        }
                    }
                }
            }
            dp = nextDp;
        }

        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
}