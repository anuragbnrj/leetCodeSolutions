class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int size = nums1.length;

        int[] diffFreq = new int[100005];
        int largestDiff = 0;
        for (int i = 0; i < size; i++) {
            int diff = (int) Math.abs(nums1[i] - nums2[i]);
            diffFreq[diff] += 1;

            largestDiff = Math.max(largestDiff, diff);
        }

        int operations = k1 + k2;
        for (int i = largestDiff; i > 0 && operations > 0; i--) {
            if (diffFreq[i] <= operations) {
                diffFreq[i - 1] += diffFreq[i];
                operations -= diffFreq[i];
                diffFreq[i] = 0;
            } else {
                diffFreq[i - 1] += operations;
                diffFreq[i] -= operations;
                operations = 0;
            }
        }

        long ans = 0;
        for (int i = largestDiff; i > 0; i--) {
            ans += 1L * diffFreq[i] * i * i;
        }

        return ans;
    }
}