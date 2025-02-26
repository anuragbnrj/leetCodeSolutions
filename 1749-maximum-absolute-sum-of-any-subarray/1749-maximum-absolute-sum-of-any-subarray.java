class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        int currMaxSum = 0;
        int currMinSum = 0;
        for (int num : nums) {
            currMaxSum = Math.max(currMaxSum + num, num);
            maxSum = Math.max(maxSum, currMaxSum);

            currMinSum = Math.min(currMinSum + num, num);
            minSum = Math.min(minSum, currMinSum);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}