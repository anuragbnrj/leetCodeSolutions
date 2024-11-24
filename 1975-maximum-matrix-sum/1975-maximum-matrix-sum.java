class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Long> list = new ArrayList<>();
        int negCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] < 0) {
                    negCount++;
                }

                list.add((long) Math.abs(matrix[r][c]));
            }
        }

        Collections.sort(list);
        long ans = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 && negCount % 2 == 1) {
                ans -= list.get(i);             
            } else {
                ans += list.get(i);
            }
        }

        return ans;
    }
}