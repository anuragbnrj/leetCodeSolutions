class Solution {
    public int[] leftRightDifference(int[] nums) {
        int size = nums.length;
        int[] leftSum = new int[size];
        int[] rightSum = new int[size];

        for (int i = 1; i < size; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        for (int i = size - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return ans;
    }
}