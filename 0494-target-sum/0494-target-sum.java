class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return rec(0, 0, nums, target);
    }

    private int rec(int idx, int currSum, int[] nums, int target) {
        if (idx == nums.length) {
            if (currSum == target) return 1;

            return 0; 
        }

        int ans = 0;
        ans += rec(idx + 1, -1 * nums[idx] + currSum, nums, target);
        ans += rec(idx + 1, 1 * nums[idx] + currSum, nums, target);

        return ans;
    }
}