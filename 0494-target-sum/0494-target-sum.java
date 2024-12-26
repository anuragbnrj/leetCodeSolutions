class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return rec(0, 0, nums, target, dp);
    }

    private int rec(int idx, int currSum, int[] nums, int target, Map<String, Integer> dp) {
        if (idx == nums.length) {
            return currSum == target ? 1 : 0;
        }

        String key = idx + "," + currSum;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int ans = 0;
        ans += rec(idx + 1, currSum - nums[idx], nums, target, dp);
        ans += rec(idx + 1, currSum + nums[idx], nums, target, dp);

        dp.put(key, ans);
        return ans;
    }
}