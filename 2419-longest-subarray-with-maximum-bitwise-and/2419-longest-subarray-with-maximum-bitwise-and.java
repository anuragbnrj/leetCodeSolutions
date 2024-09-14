class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }

        int currLen = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == mx) {
                currLen += 1;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 0;
            }
        }
        
        return maxLen;
    }
}