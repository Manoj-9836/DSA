class Solution {
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int bitCount = Integer.bitCount(arr[i]);
            arr[i] += bitCount * 100000;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 100000;
        }
        
        return arr;
    }
}