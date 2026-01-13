class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0;
        int j = 0;
        int n1 = word1.length();
        int n2 = word2.length();
        
        while (i < n1 && j < n2) {
            if (word1.substring(i).compareTo(word2.substring(j)) >= 0) {
                merge.append(word1.charAt(i));
                i++;
            } else {
                merge.append(word2.charAt(j));
                j++;
            }
        }
        
        if (i < n1) {
            merge.append(word1.substring(i));
        }
        
        if (j < n2) {
            merge.append(word2.substring(j));
        }
        
        return merge.toString();
    }
}