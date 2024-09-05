class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;

        int tot = m + n;

        int totSum = mean * tot;
        int currSum = 0;
        for (int i = 0; i < m; i++) {
            currSum += rolls[i];
        }
        int reqdSum = totSum - currSum;

        if (reqdSum < n || reqdSum > (n * 6)) {
            return new int[0];
        }

        int reqdAvg = reqdSum / n;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = reqdAvg;
        }

        int extra = reqdSum - (reqdAvg * n);
        for (int i = 0; i < n && extra > 0; i++) {
            int change = Math.min(extra, 6 - ans[i]);
            
            ans[i] += change;
            extra -= change;
        }
        
        return ans;
    }
}