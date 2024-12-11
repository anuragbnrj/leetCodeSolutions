class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int len = 100005;
        int[] freq = new int[len];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]] += 1;
        }

        for (int i = 1; i < len; i++) {
            freq[i] += freq[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int beg = Math.max(0, nums[i] - k);
            int end = Math.min(len - 1, nums[i] + k);

            if (beg == 0) {
                ans = Math.max(ans, freq[end]);
            } else {
                ans = Math.max(ans, freq[end] - freq[beg - 1]);
            }
        }

        return ans;
    }
}