class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        int j = 0;
        int n1 = str1.length();
        int n2 = str2.length();

        while (i < n1 && j < n2) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            boolean isMatch = (c1 == c2) || 
                              (c1 + 1 == c2) || 
                              (c1 == 'z' && c2 == 'a');

            if (isMatch) {
                j++;
            }
            i++;
        }

        return j == n2;
    }
}