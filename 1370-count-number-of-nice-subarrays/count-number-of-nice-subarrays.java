class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int totalNiceSubarrays = 0;
        int count = 0;
        
        while (right < nums.length) {
            if (nums[right] % 2 != 0) {
                k--;
                count = 0;
            }
            
            while (k == 0) {
                if (nums[left] % 2 != 0) {
                    k++;
                }
                
                left++;
                count++;
            }
            totalNiceSubarrays += count;
            
            right++;
        }
        return totalNiceSubarrays;
    }
}