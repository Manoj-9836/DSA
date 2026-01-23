class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countAtMost(nums, goal) - countAtMost(nums, goal - 1);
    }
    
    private int countAtMost(int[] nums, int S) {
        if (S < 0) return 0;
        
        int left = 0;
        int currentSum = 0;
        int count = 0;
        
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum > S) {
                currentSum -= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        
        return count;
    }
}