class Solution {
    public int maximumDifference(int[] nums) {
        int len = nums.length;

        int maxDiff = -1;
        int minTillNow = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > minTillNow) {
                maxDiff = Math.max(maxDiff, nums[i] - minTillNow);
            }

            minTillNow = Math.min(minTillNow, nums[i]);
        }

        return maxDiff;
    }
}