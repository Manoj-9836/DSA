class Solution {
    public String getHappyString(int n, int k) {
        int totalStrings = 3 * (1 << (n - 1));
        
        if (k > totalStrings) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        
        int groupSize = 1 << (n - 1); 
        int charIndex = (k - 1) / groupSize; 
        
        char prevChar = (char) ('a' + charIndex);
        result.append(prevChar);
        
        k = (k - 1) % groupSize + 1;
        
        for (int i = 1; i < n; i++) {
            groupSize = 1 << (n - 1 - i); 
            charIndex = (k - 1) / groupSize;
            
            char firstChoice = 'a';
            char secondChoice = 'b';
            
            if (prevChar == 'a') {
                firstChoice = 'b';
                secondChoice = 'c';
            } else if (prevChar == 'b') {
                firstChoice = 'a';
                secondChoice = 'c';
            } else {
                firstChoice = 'a';
                secondChoice = 'b';
            }
            
            prevChar = (charIndex == 0) ? firstChoice : secondChoice;
            result.append(prevChar);
            
            k = (k - 1) % groupSize + 1;
        }
        
        return result.toString();
    }
}