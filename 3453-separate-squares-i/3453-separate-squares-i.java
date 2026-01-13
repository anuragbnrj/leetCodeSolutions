class Solution {
    public double separateSquares(int[][] squares) {
        int len = squares.length;
        Arrays.sort(squares, (a, b) -> Integer.compare(a[1], b[1]));

        double totalArea = 0L;
        long minY = Long.MAX_VALUE;
        long maxYPlusL = Long.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int y = squares[i][1];
            int sz = squares[i][2];

            totalArea += 1.0 * sz * sz;
            minY = Math.min(minY, (long) y);
            maxYPlusL = Math.max(maxYPlusL, (long) y + sz);
        }

        double beg = minY;
        double end = maxYPlusL;
        for (int iter = 0; iter < 80; iter++) {
            double mid = beg + (end - beg) / 2.0;
            double areaBelow = calculateAreaBelow(squares, mid);

            if (areaBelow * 2.0 >= totalArea) {
                end = mid;   
            } else {
                beg = mid;
            }
        }

        return end;
    }

    private double calculateAreaBelow(int[][] squares, double mid) {
        double areaBelow = 0.0;
        for (int i = 0; i < squares.length; i++) {
            int y = squares[i][1];
            int sz = squares[i][2];

            if (y + sz <= mid) {
                areaBelow += 1.0 * sz * sz;
            } else if (y < mid && y + sz > mid) {
                areaBelow += 1.0 * sz * (mid - y);
            }
        }
        return areaBelow;
    }
}
