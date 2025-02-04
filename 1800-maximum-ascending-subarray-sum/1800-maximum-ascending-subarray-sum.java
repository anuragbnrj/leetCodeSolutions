class Solution {
    public int maxAscendingSum(int[] nums) {
        int len = nums.length;

        int prev = nums[0];
        int currSum = nums[0];
        int maxSum = currSum;
        for (int i = 1; i < len; i++) {
            int curr = nums[i];

            if (prev < curr) {
                currSum += curr;
            } else {
                currSum = curr;
            }

            prev = curr;
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}