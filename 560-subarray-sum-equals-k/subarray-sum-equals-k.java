class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentPrefixSum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        
        for (int num : nums) {
            currentPrefixSum += num;

            int requiredPrefix = currentPrefixSum - k;
            if (map.containsKey(requiredPrefix)) {
                count += map.get(requiredPrefix);
            }
            
            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
        }
        
        return count;
    }
}