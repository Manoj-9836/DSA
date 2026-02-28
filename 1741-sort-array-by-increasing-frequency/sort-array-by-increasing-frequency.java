class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        Integer[] boxedNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxedNums[i] = nums[i];
        }
        
        Arrays.sort(boxedNums, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB);
            }
            return Integer.compare(b, a);
        });
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedNums[i];
        }
        
        return nums;
    }
}