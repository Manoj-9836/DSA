class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> resultList = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while (i < n1 && j < n2) {
            int id1 = nums1[i][0];
            int val1 = nums1[i][1];
            int id2 = nums2[j][0];
            int val2 = nums2[j][1];

            if (id1 < id2) {
                resultList.add(new int[]{id1, val1});
                i++;
            } else if (id2 < id1) {
                resultList.add(new int[]{id2, val2});
                j++;
            } else {
                resultList.add(new int[]{id1, val1 + val2});
                i++;
                j++;
            }
        }

        while (i < n1) {
            resultList.add(nums1[i]);
            i++;
        }

        while (j < n2) {
            resultList.add(nums2[j]);
            j++;
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}