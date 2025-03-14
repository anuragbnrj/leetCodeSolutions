class Solution {
    public int maximumCandies(int[] candies, long k) {
        int len = candies.length;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += candies[i];
        }

        long beg = 1;
        long end = (sum / k) + 1;
        while (beg < end) {
            long mid = beg + (end - beg) / 2;

            if (isPossible(mid, candies, k)) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }

        return (int) (beg - 1);
    }

    private boolean isPossible(long candiesPerChild, int[] candies, long k) {
        int len = candies.length;
        long[] candiesDup = new long[len];
        for (int i = 0; i < len; i++) {
            candiesDup[i] = candies[i];
        }

        int idx = 0;
        long possibleCount = 0;
        for (int i = 0; i < len; i++) {
            possibleCount += (candiesDup[i] / candiesPerChild);
        }

        return possibleCount >= k;
    }
}