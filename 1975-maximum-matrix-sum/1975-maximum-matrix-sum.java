class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> elements = new ArrayList<>();
        int ctr = 0;
        int zeroes = 0;
        long ans = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int curr = matrix[r][c];
                if (curr < 0) {
                    ctr += 1;
                    elements.add(curr * -1);
                } else if (curr == 0) {
                    zeroes += 1;
                    elements.add(curr);
                } else {
                    elements.add(curr);
                }
            }
        }

        ctr = Math.max(0, ctr - zeroes);
        Collections.sort(elements);
        for (int i = 0; i < elements.size(); i++) {
            if (i == 0 && ctr % 2 == 1) {
                ans += (-1L * elements.get(i));
            } else {
                ans += (1L * elements.get(i));
            }
        }

        return ans;
    }
}