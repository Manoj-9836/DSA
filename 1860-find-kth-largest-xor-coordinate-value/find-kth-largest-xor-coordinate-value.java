class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] prefixXor = new int[m][n];
        
        int[] allValues = new int[m * n];
        int idx = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = matrix[i][j];
                
                int top = (i > 0) ? prefixXor[i - 1][j] : 0;
                int left = (j > 0) ? prefixXor[i][j - 1] : 0;
                int diag = (i > 0 && j > 0) ? prefixXor[i - 1][j - 1] : 0;
                
                prefixXor[i][j] = current ^ top ^ left ^ diag;
                
                allValues[idx++] = prefixXor[i][j];
            }
        }
        
        Arrays.sort(allValues);
        
        return allValues[allValues.length - k];
    }
}