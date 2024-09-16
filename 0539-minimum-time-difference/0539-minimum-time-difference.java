class Solution {
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();

        Collections.sort(timePoints);

        int minDiff = (int) 1e9;
        for (int i = 1; i < len; i++) {
            String prev = timePoints.get(i - 1);
            String curr = timePoints.get(i);

            int diff = getTimeDiff(prev, curr);

            minDiff = Math.min(minDiff, diff);
        }

        int diff = getTimeDiff(timePoints.get(0), timePoints.get(len - 1));
        minDiff = Math.min(minDiff, diff);

        return minDiff;
    }

    private int getTimeDiff(String prev, String curr) {
        int prevMinutes = getMinutesAfterMidnight(prev);
        int currMinutes = getMinutesAfterMidnight(curr);

        int more = Math.max(prevMinutes, currMinutes);
        int less = Math.min(prevMinutes, currMinutes);

        int diff = more - less;

        return Math.min(diff, 1440 - diff);
    }

    private int getMinutesAfterMidnight(String time) {
        String[] splits = time.split(":");

        return Integer.parseInt(splits[0]) * 60 + Integer.parseInt(splits[1]);
    }
}