class Solution {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long totalSum = 0;
        for (int i = 0; i < len; i++) {
            totalSum += nums[i];
        }

        long currSum = 0;
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            currSum += nums[i];

            if (currSum >= (totalSum - currSum)) ans += 1;
        }

        return ans;
    }
}