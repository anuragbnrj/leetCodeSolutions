class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        long[][] dp = new long[101][101];
        for (int r = 0; r <= 100; r++) {
            for (int c = 0; c <= 100; c++) {
                dp[r][c] = -1;
            }
        }

        long ans = rec(0, 0, robot, factory, dp);
        return ans;
    }

    private long rec(int robotIdx, int factoryIdx, List<Integer> robot, int[][] factory, long[][] dp) {
        if (robotIdx >= robot.size()) {
            return 0;
        }

        if (factoryIdx == factory.length) {
            return (long) 1e18;
        }

        if (dp[robotIdx][factoryIdx] != -1) {
            return dp[robotIdx][factoryIdx];
        }

        int canRepair = factory[factoryIdx][1];
        long currFactPos = factory[factoryIdx][0];

        long ans = (long) 1e18;
        long currCost = 0;
        ans = Math.min(ans, rec(robotIdx, factoryIdx + 1, robot, factory, dp));
        for (int i = 0; i < canRepair && (robotIdx + i) < robot.size(); i++) {
            currCost += Math.abs(robot.get(robotIdx + i) - currFactPos);

            ans = Math.min(ans, currCost + rec(robotIdx + i + 1, factoryIdx + 1, robot, factory, dp));  
        }

        dp[robotIdx][factoryIdx] = ans;
        return dp[robotIdx][factoryIdx];
    }
}
