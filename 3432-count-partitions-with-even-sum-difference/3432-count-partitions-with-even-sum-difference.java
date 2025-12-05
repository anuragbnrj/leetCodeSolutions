class Solution {
    public int countPartitions(int[] nums) {
        int len = nums.length;
        // int leftSumEven = 0;
        int totSum = 0;
        for (int i = 0; i < len - 1; i++) {
            totSum += nums[i];

            // if (totSum % 2 == 0) {
            //     leftSumEven += 1;
            // }
        }

        totSum += nums[len - 1];

        if (totSum % 2 == 0) {
            return len - 1;
        }

        return 0;
        
    }
}