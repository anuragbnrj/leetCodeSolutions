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
            ans = Math.max(ans, getCount(nums[i] - k - k, nums[i], freq));
            ans = Math.max(ans, getCount(nums[i] - k, nums[i] + k, freq));
            ans = Math.max(ans, getCount(nums[i], nums[i] + k + k, freq));
        }

        return ans;
    }

    private int getCount(int beg, int end, int[] freq) {
        int ans = 0;

        beg = Math.max(0, beg);
        end = Math.min(freq.length - 1, end);

        if (beg == 0) {
            ans = Math.max(ans, freq[end]);
        } else {
           ans = Math.max(ans, freq[end] - freq[beg - 1]);
        }

        return ans;
    }
}