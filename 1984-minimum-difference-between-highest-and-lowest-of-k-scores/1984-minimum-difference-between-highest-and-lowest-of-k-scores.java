class Solution {
    public int minimumDifference(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < len; i++) {
            int currDiff = nums[i + k - 1] - nums[i];

            minDiff = Math.min(minDiff, currDiff);
        }
        
        return minDiff;
    }
}