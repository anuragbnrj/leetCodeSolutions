class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int len = points.length;

        int ans = 0;
        for (int i = 1; i < len; i++) {
            int currX = points[i][0];
            int currY = points[i][1];

            int prevX = points[i - 1][0];
            int prevY = points[i - 1][1];

            int diffX = (int) Math.abs(currX - prevX);
            int diffY = (int) Math.abs(currY - prevY);

            ans += Math.max(diffX, diffY);
        }

        return ans;
    }
}