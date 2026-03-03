class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int invertCount = 0;
        int length = (1 << n) - 1; 
        int target = k - 1; 

        while (length > 1) {
            int mid = length / 2; 

            if (target == mid) {
                return invertCount % 2 == 0 ? '1' : '0';
            } else if (target > mid) {
                target = length - target - 1;
                invertCount++;
            }
            length = mid;
        }
        return invertCount % 2 == 0 ? '0' : '1';
    }
}