class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, i, 0);
        }

        return nums;
    }

    private void heapify(int[] nums, int heapSize, int i) {
        while (true) {
            int largest = i;
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            if (leftChild < heapSize && nums[leftChild] > nums[largest]) {
                largest = leftChild;
            }

            if (rightChild < heapSize && nums[rightChild] > nums[largest]) {
                largest = rightChild;
            }

            if (largest != i) {
                int temp = nums[i];
                nums[i] = nums[largest];
                nums[largest] = temp;
                
                i = largest; 
            } else {
                break; 
            }
        }
    }
}