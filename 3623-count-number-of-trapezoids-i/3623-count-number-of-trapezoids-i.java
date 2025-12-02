class Solution {
    private static final long MOD = (long) 1e9 + 7;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> yfreq = new HashMap<>();

        long zeroSlopeLines = 0;
        long ans = 0;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            int currFreq = yfreq.getOrDefault(y, 0);
            long newZeroSlopeLines = 1L * currFreq;

            if (newZeroSlopeLines > 0) {
                long linesAtSameY = (1L * currFreq * (currFreq - 1) / 2) % MOD;
                long eligibleLines = (((zeroSlopeLines -  linesAtSameY) % MOD) + MOD) % MOD;
                ans = (ans + (eligibleLines * newZeroSlopeLines) % MOD) % MOD;
            }

            zeroSlopeLines = (zeroSlopeLines + newZeroSlopeLines) % MOD;
            yfreq.put(y, currFreq + 1);
        }
        
        return (int) ans;
    }
}