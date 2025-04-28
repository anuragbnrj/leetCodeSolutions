class Solution {
    public long countSubarrays(int[] nums, long k) {
        int len = nums.length;

        int left = 0;
        int right = -1;
        long currSum = 0;
        long ans = 0;
        while (left < len) {
            while (right + 1 < len && (((currSum + nums[right + 1]) * (right + 1 - left + 1)) < k)) {
                right += 1;
                currSum += nums[right];
            }

            if (left <= right) {
                ans += (right - left + 1);

                currSum = currSum - nums[left];

                left += 1;
            } else {
                left += 1;
                right = left - 1;
            }

        }

        return ans;
    }
}