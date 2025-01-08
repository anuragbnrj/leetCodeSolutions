class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            int curr = nums[i];
            int temp = Math.max(curr, Math.max(curr * maxSoFar, curr * minSoFar));
            minSoFar = Math.min(curr, Math.min(curr * maxSoFar, curr * minSoFar));

            maxSoFar = temp;
            ans = Math.max(ans, maxSoFar);
        }

        return ans;
    }
}