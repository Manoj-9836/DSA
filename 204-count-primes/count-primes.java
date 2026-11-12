class Solution {
    public int countPrimes(int n) {
       if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p < n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        int[] dp = new int[n + 1];
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (isPrime[i - 1] ? 1 : 0);
        }

        return dp[n];
    }
}