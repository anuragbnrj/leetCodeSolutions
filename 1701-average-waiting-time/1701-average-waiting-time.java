class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;

        long currTime = 0;
        long totalWaitTime = 0;
        for (int i = 0; i < n; i++) {
            int arrival = customers[i][0];
            int prepTime = customers[i][1];

            if (currTime <= arrival) {
                totalWaitTime += prepTime;
                currTime = arrival + prepTime;
            } else {
                totalWaitTime += (currTime - arrival) + prepTime;
                currTime += prepTime;
            }
        }

        double ans = (1.0 * totalWaitTime) / n;

        return ans;
    }
}