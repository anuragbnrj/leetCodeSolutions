class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        int hMax = 1;
        int currStreak = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == (hBars[i - 1] + 1)) {
                currStreak += 1;
                hMax = Math.max(hMax, currStreak);
            } else {
                currStreak = 1;
            }
        }
        hMax += 1;
        
        Arrays.sort(vBars);
        int vMax = 1;
        currStreak = 1;
        for (int j = 1; j < vBars.length; j++) {
            if (vBars[j] == (vBars[j - 1] + 1)) {
                currStreak += 1;
                vMax = Math.max(vMax, currStreak);
            } else {
                currStreak = 1;
            }
        }
        vMax += 1;

        return Math.min(hMax, vMax) * Math.min(hMax, vMax);
    }
}