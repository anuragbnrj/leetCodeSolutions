class Solution {
    public int minOperations(int[][] grid, int x) {
        int rows = grid.length;
        int cols = grid[0].length;

        int size = rows * cols;
        int[] arr = new int[size];
        int idx = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                arr[idx++] = grid[r][c];
            }
        }
        Arrays.sort(arr);

        int[] fromBeg = new int[size];
        int[] fromEnd = new int[size];
        for (int l = 1, r = size - 2; l < size; l++, r--) {
            int diff = arr[l] - arr[l - 1];
            if ((diff % x) != 0) return -1;
            fromBeg[l] = fromBeg[l - 1] + l * (diff / x);

            diff = arr[r + 1] - arr[r];
            if ((diff % x) != 0) return -1;
            fromEnd[r] = fromEnd[r + 1] + (size - r - 1) * (diff / x);
        }

        // System.out.println("fromBeg: " + Arrays.toString(fromBeg));
        // System.out.println("fromEnd: " + Arrays.toString(fromEnd));

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            ans = Math.min(ans, fromBeg[i] + fromEnd[i]);
        }

        return ans;
    }
}