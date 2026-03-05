class Solution {
    public int minOperations(String s) {
        int diffA = 0;
        int diffB = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            char expectedA = (i % 2 == 0) ? '0' : '1';
            char expectedB = (i % 2 == 0) ? '1' : '0';
            
            if (currentChar != expectedA) {
                diffA++;
            }
            if (currentChar != expectedB) {
                diffB++;
            }
        }
        
        return Math.min(diffA, diffB);
    }
}