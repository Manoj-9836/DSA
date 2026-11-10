class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        
        int total = 10;
        int currentChoice = 9;
        int availableDigits = 9;
        
        for (int i = 2; i <= n; i++) {
            currentChoice *= availableDigits;
            total += currentChoice;
            availableDigits--;
        }
        
        return total;
    }
}