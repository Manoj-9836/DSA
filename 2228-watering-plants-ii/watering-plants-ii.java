class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0;
        int right = plants.length - 1;
        
        int waterA = capacityA;
        int waterB = capacityB;
        int refills = 0;

        while (left < right) {
            if (waterA < plants[left]) {
                refills++;       
                waterA = capacityA;
            }
            waterA -= plants[left]; 
            left++;

            if (waterB < plants[right]) {
                refills++;  
                waterB = capacityB;
            }
            waterB -= plants[right];
            right--;
        }

        if (left == right) {
            if (waterA >= waterB) {
                if (waterA < plants[left]) {
                    refills++;
                }
            } else {
                if (waterB < plants[right]) {
                    refills++;
                }
            }
        }
        return refills;
    }
}