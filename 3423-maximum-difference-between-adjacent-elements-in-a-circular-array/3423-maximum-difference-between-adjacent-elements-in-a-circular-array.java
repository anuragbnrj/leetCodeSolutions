class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int len = nums.length;

        int ans = -100000000;
        for (int i = 0; i < len; i++) {
            int diff = Math.abs(nums[i] - nums[(i + 1) % len]);
            ans = Math.max(ans, diff);
        }

        return ans;
    }
}