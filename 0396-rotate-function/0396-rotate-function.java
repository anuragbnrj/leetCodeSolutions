class Solution {
    public int maxRotateFunction(int[] nums) {
        int size = nums.length;
        
        int baseline = 0;
        int csum = 0;
        for (int i = 0; i < size; i++) {
            baseline += (i * nums[i]);
            csum += nums[i];
        }
        
        int ans = baseline;
        int currSum = baseline;
        for (int i = size - 1; i > 0; i--) {
            int delta = (csum - nums[i]) - ((size - 1) * nums[i]);

            ans = Math.max(ans, currSum + delta);

            currSum += delta;
        }

        return ans;
    }
}