class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int ans = 0;
        int prevEnd = intervals[0][0];
        int i = 0;
        while (i < n) {
            while (i < n && intervals[i][0] < prevEnd) {
                i += 1;
                ans += 1;
            }

            if (i < n) {
                prevEnd = intervals[i][1];
            }
            i++;
        }

        return ans;
    }
}