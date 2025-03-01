class Solution {
    public int[] applyOperations(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int curr = nums[i];
            int next = nums[i + 1];

            if (curr == next) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int[] ans = new int[len];
        int nzptr = 0, zptr = len - 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                ans[zptr] = 0;
                zptr -= 1;
            } else {
                ans[nzptr] = nums[i];
                nzptr += 1;
            }
        }

        return ans;
    }
}