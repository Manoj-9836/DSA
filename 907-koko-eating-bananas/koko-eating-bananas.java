class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int hoursUsed = 0;
        for (int pile : piles) {
            hoursUsed += (pile + k - 1) / k;
            
            if (hoursUsed > h) return false;
        }
        return true;
    }
}