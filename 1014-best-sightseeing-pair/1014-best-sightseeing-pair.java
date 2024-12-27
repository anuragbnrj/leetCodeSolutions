class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int maxTillNow = values[0];

        int ans = 0;
        for (int i = 1; i < len; i++) {
            ans = Math.max(ans, values[i] + maxTillNow - i);

            maxTillNow = Math.max(maxTillNow, values[i] + i);
        }

        return ans;
    }
}