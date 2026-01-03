class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int lastAddedIndex = -1;

        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(0, j - k);
                int end = Math.min(n - 1, j + k);
                int actualStart = Math.max(start, lastAddedIndex + 1);
                
                for (int i = actualStart; i <= end; i++) {
                    result.add(i);
                    lastAddedIndex = i;
                }
            }
        }
        
        return result;
    }
}