class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 == 1) {
            return false;
        }

        int len = nums.length;
        boolean[][] isCached = new boolean[len + 1][totalSum / 2 + 1];
        boolean[][] cache = new boolean[len + 1][totalSum / 2 + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(isCached[i], false);
            Arrays.fill(cache[i], false);
        }

        return isPossible(0, totalSum / 2, nums, isCached, cache);
    }

    private boolean isPossible(int idx, int requiredSum, int[] nums, boolean[][] isCached, boolean[][] cache) {
        if (requiredSum == 0) {
            return true;
        }

        if (idx == nums.length) {
            return false;
        }

        if (isCached[idx][requiredSum]) {
            return cache[idx][requiredSum];
        }

        boolean ans = false;
        // not pick
        ans = ans || isPossible(idx + 1, requiredSum, nums, isCached, cache);

        // pick
        if (nums[idx] <= requiredSum) {
            ans = ans || isPossible(idx + 1, requiredSum - nums[idx], nums, isCached, cache);
        }

        cache[idx][requiredSum] = ans;
        isCached[idx][requiredSum] = true;
        return ans;
    }
}