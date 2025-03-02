class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] sum = new int[1001];

        int count = 0;
        for (int[] num : nums1) {
            int id = num[0];
            int val = num[1];

            sum[id] += val;

            count += 1;
        }

        for (int[] num : nums2) {
            int id = num[0];
            int val = num[1];

            if (sum[id] == 0) count += 1;

            sum[id] += val;
        }

        int[][] ans = new int[count][2];
        int idx = 0;
        for (int i = 0; i < sum.length; i++) {
            int id = i;
            int val = sum[i];

            if (val != 0) {
                ans[idx][0] = id;
                ans[idx][1] = val;

                idx += 1;
            }
        }

        return ans;
    }
}