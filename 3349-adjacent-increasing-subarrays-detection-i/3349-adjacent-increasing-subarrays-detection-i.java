class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int len = nums.size();
        int[] longestSubarrayEndingAt = new int[len];
        longestSubarrayEndingAt[0] = 1;

        for (int i = 1; i < len; i++) {
            int prev = nums.get(i - 1);
            int curr = nums.get(i);

            if (curr > prev) {
                longestSubarrayEndingAt[i] = longestSubarrayEndingAt[i - 1] + 1;
            } else {
                longestSubarrayEndingAt[i] = 1;
            }
        }

        for (int i = 0; (i + k + k - 1) < len; i++) {
            if (longestSubarrayEndingAt[i + k - 1] >= k && longestSubarrayEndingAt[i + k + k - 1] >= k) {
                return true;
            }
        }

        return false;
    }
}