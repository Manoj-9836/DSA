class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k) + k - 1) {
            return false;
        }
        
        int requiredCount = 1 << k;
        
        boolean[] seen = new boolean[requiredCount];
        int uniqueCount = 0;
        
        int mask = requiredCount - 1; 
        int rollingHash = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int newBit = s.charAt(i) - '0';
            rollingHash = ((rollingHash << 1) & mask) | newBit;
            
            if (i >= k - 1) {
                if (!seen[rollingHash]) {
                    seen[rollingHash] = true;
                    uniqueCount++;
                    
                    if (uniqueCount == requiredCount) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}