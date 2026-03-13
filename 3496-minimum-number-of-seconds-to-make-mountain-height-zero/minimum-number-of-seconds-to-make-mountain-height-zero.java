class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long minWorkerTime = workerTimes[0];
        for (int w : workerTimes) {
            minWorkerTime = Math.min(minWorkerTime, w);
        }
        
        long low = 1;
        long high = minWorkerTime * (long) mountainHeight * (mountainHeight + 1) / 2;
        long minSeconds = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canFinish(mid, mountainHeight, workerTimes)) {
                minSeconds = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return minSeconds;
    }
    
    private boolean canFinish(long timeLimit, int mountainHeight, int[] workerTimes) {
        long totalReduced = 0;
        
        for (int w : workerTimes) {
            long maxVal = timeLimit / w; 
            
            long l = 0;
            long r = mountainHeight;
            long workerX = 0;
            
            while (l <= r) {
                long mid = l + (r - l) / 2;
                if (mid * (mid + 1) / 2 <= maxVal) {
                    workerX = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            
            totalReduced += workerX;
            
            if (totalReduced >= mountainHeight) {
                return true;
            }
        }
        
        return totalReduced >= mountainHeight;
    }
}