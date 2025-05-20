class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int len = nums.length;
        int[] psum = new int[len + 1];

        for (int[] query : queries) {
            int beg = query[0];
            int end = query[1];

            psum[beg] -= 1;
            psum[end + 1] += 1;
        }

        for (int i = 0; i < len; i++) {
            if (i != 0) psum[i] += psum[i - 1];

            if (nums[i] + psum[i] > 0) return false;
        }

        return true;
    }
}