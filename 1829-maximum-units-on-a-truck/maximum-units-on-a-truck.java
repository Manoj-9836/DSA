class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        
        int totalUnits = 0;
        for (int[] box : boxTypes) {
            int availableBoxes = box[0];
            int unitsPerBox = box[1];
            
            int boxesToTake = Math.min(truckSize, availableBoxes);
            totalUnits += boxesToTake * unitsPerBox;
            truckSize -= boxesToTake;
            if (truckSize == 0) {
                break;
            }
        }
        
        return totalUnits; 
    }
}