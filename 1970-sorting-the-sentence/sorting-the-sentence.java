class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        
        String[] result = new String[words.length];
        
        for (String word : words) {
            int length = word.length();
            
            int index = word.charAt(length - 1) - '1';
            
            String actualWord = word.substring(0, length - 1);
            
            result[index] = actualWord;
        }
        
        return String.join(" ", result);
    }
}