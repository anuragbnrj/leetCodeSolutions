class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] shifted = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            int[] row = mat[r];
            int[] shiftedRow = rotateArray(row, k, r % 2);

            shifted[r] = shiftedRow;
        }

        return compareMatrices(mat, shifted);

    }

    private int[] rotateArray(int[] arr, int k, int shiftDir) {
        int n = arr.length;
        k = k % n;
        int[] result = arr.clone();

        if (k == 0)
            return result;

        if (shiftDir == 1) { // right shift
            reverse(result, 0, n - k - 1);
            reverse(result, n - k, n - 1);
            reverse(result, 0, n - 1);
        } else { // left shift
            reverse(result, 0, k - 1);
            reverse(result, k, n - 1);
            reverse(result, 0, n - 1);
        }

        return result;
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    private boolean compareMatrices(int[][] src, int[][] tar) {
        int rows = src.length;
        int cols = src[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (src[r][c] != tar[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }

}