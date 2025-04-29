class Solution {
    public long countSubarrays(int[] nums, int k) {
        int len = nums.length;
        int maxEl = 0;
        for (int i = 0; i < len; i++) {
            maxEl = Math.max(maxEl, nums[i]);
        }

        int left = 0;
        int right = -1;
        int currMaxElCount = 0;
        long ans = 0;
        while (left < len) {
            while (right + 1 < len && currMaxElCount < k) {
                right += 1;

                if (nums[right] == maxEl) {
                    currMaxElCount += 1;
                }
            }

            if (currMaxElCount >= k) {
                // System.out.println("left: " + left + ", right: " + right + ", delta: " + (len - right));
                ans += (len - right);
            }

            if (left <= right) {
                if (nums[left] == maxEl) {
                    currMaxElCount -= 1;
                }
                left += 1;
            } else {
                left += 1;
                right = left - 1;
            }
        }

        return ans;
    }
}