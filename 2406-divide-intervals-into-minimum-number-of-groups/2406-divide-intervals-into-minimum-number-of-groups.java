class Solution {
    public int minGroups(int[][] intervals) {
        int windowSize = (int) 1e6 + 2;
        int[] freq = new int[windowSize];

        for (int i = 0; i < intervals.length; i++) {
            int beg = intervals[i][0];
            int end = intervals[i][1];

            freq[beg] += 1;
            freq[end + 1] -= 1;
        }

        int ans = 0;
        for (int i = 1; i < windowSize; i++) {
            freq[i] = freq[i - 1] + freq[i];

            ans = Math.max(ans, freq[i]);
        }

        return ans;
    }
}