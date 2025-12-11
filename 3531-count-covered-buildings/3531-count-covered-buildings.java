class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, Integer> rowBeg = new HashMap<>();
        Map<Integer, Integer> rowEnd = new HashMap<>();
        Map<Integer, Integer> colBeg = new HashMap<>();
        Map<Integer, Integer> colEnd = new HashMap<>();

        for (int[] building : buildings) {
            int row = building[0];
            int col = building[1];

            int rowMin = Math.min(col, rowBeg.getOrDefault(row, Integer.MAX_VALUE));
            rowBeg.put(row, rowMin);
            int rowMax = Math.max(col, rowEnd.getOrDefault(row, Integer.MIN_VALUE));
            rowEnd.put(row, rowMax);

            int colMin = Math.min(row, colBeg.getOrDefault(col, Integer.MAX_VALUE));
            colBeg.put(col, colMin);
            int colMax = Math.max(row, colEnd.getOrDefault(col, Integer.MIN_VALUE));
            colEnd.put(col, colMax);
        }

        int ans = 0;
        for (int[] building : buildings) {
            int row = building[0];
            int col = building[1];

            int rowMin = rowBeg.get(row);
            int rowMax = rowEnd.get(row);

            int colMin = colBeg.get(col);
            int colMax = colEnd.get(col);

            if (rowMin < col && col < rowMax && colMin < row && row < colMax) {
                ans += 1;
            }
        }

        return ans;
    }
}