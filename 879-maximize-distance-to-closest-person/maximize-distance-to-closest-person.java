class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int lastPerson = -1; 
        int maxDist = 0;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (lastPerson == -1) {
                    maxDist = i; 
                } else {
                    maxDist = Math.max(maxDist, (i - lastPerson) / 2);
                }
                lastPerson = i;
            }
        }
        maxDist = Math.max(maxDist, n - 1 - lastPerson);

        return maxDist;
    }
}