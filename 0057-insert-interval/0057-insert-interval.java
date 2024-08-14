class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        List<int[]> intervalList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            intervalList.add(intervals[i]);
        }
        intervalList.add(newInterval);

        Collections.sort(intervalList, (a, b) -> {
            return a[0] - b[0];
        });

        int prevBeg = intervalList.get(0)[0];
        int prevEnd = intervalList.get(0)[1];
        List<int[]> tempAns = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int currBeg = intervalList.get(i)[0];
            int currEnd = intervalList.get(i)[1];

            int intersection = Math.min(prevEnd, currEnd) - Math.max(prevBeg, currBeg);

            if (intersection >= 0) {
                prevBeg = Math.min(prevBeg, currBeg);
                prevEnd = Math.max(prevEnd, currEnd);
            } else {
                tempAns.add(new int[]{prevBeg, prevEnd});
                prevBeg = currBeg;
                prevEnd = currEnd;
            }
        }
        tempAns.add(new int[]{prevBeg, prevEnd});

        int[][] ans = new int[tempAns.size()][];
        for (int i = 0; i < tempAns.size(); i++) {
            ans[i] = tempAns.get(i);
        }

        return ans;
    }
}