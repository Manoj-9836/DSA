class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0;
        int right = 0;
        int result = 0;
        int n = s.length();
        
        while (right < n) {
            count[s.charAt(right) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += (n - right);
                count[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        
        return result;
    }
}