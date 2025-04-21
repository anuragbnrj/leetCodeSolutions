class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int len = differences.length;
        long mn = 0;
        long mx = 0;

        long prev = 0;
        for (int i = 0; i < len; i++) {
            long curr = prev + differences[i];

            mn = Math.min(mn, curr);
            mx = Math.max(mx, curr);

            prev = curr;
        }
        // System.out.println("mn: " + mn + ", mx: " + mx);

        long rangeLen = mx - mn + 1;
        if (rangeLen > (upper - lower + 1)) {
            return 0;
        }

        return (int) ((upper - lower + 1) - rangeLen + 1);
    }
}