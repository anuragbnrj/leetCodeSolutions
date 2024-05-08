class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<List<Integer>> tempRes = new ArrayList<>();
        
        int prevBeg = intervals[0][0];
        int prevEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int currBeg = intervals[i][0];
            int currEnd = intervals[i][1];
            
            int overlap = Math.max(-1, Math.min(currEnd, prevEnd) - Math.max(currBeg, prevBeg));

            if (overlap == -1) {
                List<Integer> temp = Arrays.asList(prevBeg, prevEnd);
                tempRes.add(temp);
                prevBeg = currBeg;
                prevEnd = currEnd;
            } else {
                prevBeg = Math.min(prevBeg, currBeg);
                prevEnd = Math.max(prevEnd, currEnd);
            }
        }
        
        List<Integer> temp = Arrays.asList(prevBeg, prevEnd);
        tempRes.add(temp);

        int[][] res = new int[tempRes.size()][2];
        for (int i = 0; i < tempRes.size(); i++) {
            res[i][0] = tempRes.get(i).get(0);
            res[i][1] = tempRes.get(i).get(1);
        }

        return res;
    }
}