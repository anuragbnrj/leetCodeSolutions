class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        int n = intervals.length;
        int prevBeg = intervals[0][0];
        int prevEnd = intervals[0][1];
        List<int[]> temp = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int currBeg = intervals[i][0];
            int currEnd = intervals[i][1];

            int intersection = Math.min(prevEnd, currEnd) - Math.max(prevBeg, currBeg);

            if (intersection >= 0) {
                prevBeg = Math.min(prevBeg, currBeg);
                prevEnd = Math.max(prevEnd, currEnd);
            } else {
                temp.add(new int[]{prevBeg, prevEnd});

                prevBeg = currBeg;
                prevEnd = currEnd;
            }  
        }
        temp.add(new int[]{prevBeg, prevEnd});

        return temp.toArray(new int[temp.size()][]);
    }
}