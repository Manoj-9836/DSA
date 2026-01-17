class Solution {
    public long minimumSteps(String s) {
        long totalSwaps = 0;
        long blackBallCount = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '1') {
                blackBallCount++;
            } else {
                totalSwaps += blackBallCount;
            }
        }
        
        return totalSwaps;
    }
}