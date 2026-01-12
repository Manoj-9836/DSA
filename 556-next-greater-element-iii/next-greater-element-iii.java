class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;
        
        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        
        if (i < 0) {
            return -1;
        }
        
        int j = len - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
        
        swap(digits, i, j);
        reverse(digits, i + 1, len - 1);
        
        try {
            long result = Long.parseLong(new String(digits));
            if (result > Integer.MAX_VALUE) {
                return -1;
            }
            return (int) result;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}