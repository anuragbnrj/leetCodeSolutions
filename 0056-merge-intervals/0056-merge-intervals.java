class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int len = intervals.length;
        List<int[]> ansList = new ArrayList<>();
        ansList.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < len; i++) {
            int prevBeg = ansList.get(ansList.size() - 1)[0];
            int prevEnd = ansList.get(ansList.size() - 1)[1];

            int currBeg = intervals[i][0];
            int currEnd = intervals[i][1];

            int overlap = Math.max(-1, Math.min(prevEnd, currEnd) - Math.max(prevBeg, currBeg));

            if (overlap > -1) {
                ansList.set(ansList.size() - 1, new int[]{Math.min(prevBeg, currBeg), Math.max(prevEnd, currEnd)});
            } else {
                ansList.add(new int[]{currBeg, currEnd});
            }
        }

        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            int currBeg = ansList.get(i)[0];
            int currEnd = ansList.get(i)[1];

            ans[i][0] = currBeg;
            ans[i][1] = currEnd;
        }

        return ans;
    }
}