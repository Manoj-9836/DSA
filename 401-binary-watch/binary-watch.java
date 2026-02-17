class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    
                    StringBuilder time = new StringBuilder();
                    time.append(h).append(":");
                    
                    if (m < 10) {
                        time.append("0");
                    }
                    time.append(m);
                    
                    result.add(time.toString());
                }
            }
        }
        
        return result;
    }
}