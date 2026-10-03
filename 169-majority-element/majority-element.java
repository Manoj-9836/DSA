class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>(); 
        int majorityCount = nums.length / 2;

        for (int i = 0; i < nums.length; i++) { 
            int count = seen.getOrDefault(nums[i], 0) + 1;
            seen.put(nums[i], count);
            
            if (count > majorityCount) {
                return nums[i];
            }
        }
        
        return -1;
    }
}