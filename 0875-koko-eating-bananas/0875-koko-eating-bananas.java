class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int beg = 1;
        int end = (int) 1e9;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (!isPossible(piles, h, mid)) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }

    private boolean isPossible(int[] piles, int h, int speed) {
        int n = piles.length;

        int hoursTaken = 0;
        for (int i = 0; i < n; i++) {
            hoursTaken += (int) Math.ceil( (1.0 * piles[i]) / speed);
        }

        if (hoursTaken <= h) {
            return true;
        }
        return false;
    }
}