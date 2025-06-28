class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;

        boolean[] pick = new boolean[len];
        for (int iter = 0; iter < k; iter++) {
            int currMax = (int) -1E9;
            int currMaxIdx = -1;
            for (int i = 0; i < len; i++) {
                if (!pick[i] && nums[i] > currMax) {
                    currMax = nums[i];
                    currMaxIdx = i;
                }
            }

            pick[currMaxIdx] = true;
        }
        
        int[] ans = new int[k];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (pick[i]) {
                ans[idx++] = nums[i];
            }
        }

        return ans;
    }
}