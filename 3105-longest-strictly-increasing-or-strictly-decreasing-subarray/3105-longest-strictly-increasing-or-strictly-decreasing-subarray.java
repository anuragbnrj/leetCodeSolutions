class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int len = nums.length;

        int prev = nums[0];
        int currIncSz = 1;
        int currDecSz = 1;
        int ans = 1;
        for (int i = 1; i < len; i++) {
            int curr = nums[i];
            if (curr > prev) {
                currIncSz += 1;
                currDecSz = 1;   
            } else if (curr < prev) {
                currIncSz = 1;
                currDecSz += 1;
            } else {
                currIncSz = 1;
                currDecSz = 1;
            }

            prev = curr;
            ans = Math.max(ans, Math.max(currIncSz, currDecSz));
        }

        return ans;
    }
}