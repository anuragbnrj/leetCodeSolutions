class Solution {
    public long coloredCells(int n) {
        long diff = 0;
        int coloredCells = 1;
        for (int i = 1; i <= n; i++) {
            coloredCells += diff;
            diff += 4;
        }

        return coloredCells;
    }
}