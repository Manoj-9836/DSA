class Solution {
    public String frequencySort(String s) {
        // 1. Count frequencies using a fast ASCII array
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        
        // 2. Create buckets where the array index equals the character's frequency
        // The max frequency is s.length()
        StringBuilder[] buckets = new StringBuilder[s.length() + 1];
        
        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                int count = freq[i];
                if (buckets[count] == null) {
                    buckets[count] = new StringBuilder();
                }
                // Store the character in the bucket corresponding to its count
                buckets[count].append((char) i); 
            }
        }
        
        // 3. Build the final string reading from highest frequency to lowest
        StringBuilder result = new StringBuilder();
        
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                // For every character in this frequency bucket
                for (char c : buckets[i].toString().toCharArray()) {
                    // Append it 'i' times (since 'i' is the frequency)
                    for (int j = 0; j < i; j++) {
                        result.append(c);
                    }
                }
            }
        }
        
        return result.toString();
    }
}