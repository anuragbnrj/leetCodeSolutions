class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int beg = 0;
        int end = (rows * cols);

        while (beg < end) {
            int mid = beg + ((end - beg) / 2);

            int r = mid / cols;
            int c = mid % cols;

            System.out.println("mid: " + mid + ", r: " + r + ", c: " + c);

            if (matrix[r][c] < target) beg = mid + 1;
            else end = mid;
        }

        int r = beg / cols;
        int c = beg % cols;

        if (beg == (rows * cols) || matrix[r][c] != target) {
            return false;
        }

        return true;
    }
}