class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            int idx = (((i + nums[i]) % len) + len) % len;
            res[i] = nums[idx];
        }

        return res;
    }
}