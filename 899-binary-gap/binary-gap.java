class Solution {
    public int binaryGap(int n) {
        int maxDistance = 0;
        int lastSeenPosition = -1;
        int currentPosition = 0;
        
        while (n > 0) {
            if ((n & 1) == 1) {
                if (lastSeenPosition != -1) {
                    int distance = currentPosition - lastSeenPosition;
                    maxDistance = Math.max(maxDistance, distance);
                }
                lastSeenPosition = currentPosition;
            }
            
            n >>= 1;
            currentPosition++;
        }
        
        return maxDistance;
    }
}