class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        TreeSet<Integer> topSums = new TreeSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                for (int L = 0; i + 2 * L < m && j - L >= 0 && j + L < n; L++) {
                    int currentSum = 0;
                    
                    if (L == 0) {
                        currentSum = grid[i][j];
                    } else {
                        int r = i;
                        int c = j;
                        
                        for (int k = 0; k < L; k++) {
                            currentSum += grid[r][c];
                            r++; c++;
                        }
                        for (int k = 0; k < L; k++) {
                            currentSum += grid[r][c];
                            r++; c--;
                        }
                        for (int k = 0; k < L; k++) {
                            currentSum += grid[r][c];
                            r--; c--;
                        }
                        for (int k = 0; k < L; k++) {
                            currentSum += grid[r][c];
                            r--; c++;
                        }
                    }
                    
                    topSums.add(currentSum);
                    if (topSums.size() > 3) {
                        topSums.pollFirst();
                    }
                }
            }
        }
        
        int[] result = new int[topSums.size()];
        int index = topSums.size() - 1;
        for (int sum : topSums) {
            result[index--] = sum;
        }
        
        return result;
    }
}