class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int anchor = 0;
        
        for (int read = 0; read < chars.length; read++) {
            
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                
                chars[write++] = chars[anchor];
                
                int groupLength = read - anchor + 1;
                if (groupLength > 1) {
                    for (char c : Integer.toString(groupLength).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        
        return write;
    }
}