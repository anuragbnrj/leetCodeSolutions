class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int len = nums.length;

        int left = 0, right = -1;
        long ans = 0;
        while (left < len) {
            while (right + 1 < len && nums[right + 1] == 0) {
                right += 1;
            }

            ans += right - left + 1;

            if (left <= right) {
                left += 1;
            } else {
                left += 1;
                right = left - 1;
            }
        }

        return ans;
    }
}