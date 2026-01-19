class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        if (words1.length > words2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        
        int n1 = words1.length;
        int n2 = words2.length;
        
        int left = 0;
        int right = 0;
        
        while (left < n1 && words1[left].equals(words2[left])) {
            left++;
        }
        while (right < n1 && words1[n1 - 1 - right].equals(words2[n2 - 1 - right])) {
            right++;
        }
        
        return left + right >= n1;
    }
}