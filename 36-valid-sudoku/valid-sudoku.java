class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] seenRows = new boolean[9][10];
        boolean[][] seenCols = new boolean[9][10];
        boolean[][] seenBoxes = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                
                if (current == '.') {
                    continue;
                }
                
                int num = current - '0';
                
                int boxIndex = (i / 3) * 3 + (j / 3);
                
                if (seenRows[i][num] || seenCols[j][num] || seenBoxes[boxIndex][num]) {
                    return false;
                }
        
                seenRows[i][num] = true;
                seenCols[j][num] = true;
                seenBoxes[boxIndex][num] = true;
            }
        }
        
        return true;
    }
}