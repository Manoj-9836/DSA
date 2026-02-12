class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0]; 
            starts[i][1] = i;             
        }
        
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int targetEnd = intervals[i][1];
            
            int rightIntervalIndex = binarySearch(starts, targetEnd);
            result[i] = rightIntervalIndex;
        }
        
        return result;
    }
    
    private int binarySearch(int[][] starts, int target) {
        int left = 0; 
        int right = starts.length - 1;
        int res = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (starts[mid][0] >= target) {
                res = starts[mid][1];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return res;
    }
}