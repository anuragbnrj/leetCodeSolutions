class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        Map<Integer, ArrayList<Integer>> sameRow = new HashMap<>();
        Map<Integer, ArrayList<Integer>> sameCol = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = stones[i][0];
            int y = stones[i][1];

            ArrayList<Integer> rowNeighbours = sameRow.getOrDefault(y, new ArrayList<>());
            rowNeighbours.add(x);
            sameRow.put(y, rowNeighbours);

            ArrayList<Integer> colNeighbours = sameCol.getOrDefault(x, new ArrayList<>());
            colNeighbours.add(y);
            sameCol.put(x, colNeighbours);
        }

        // System.out.println(sameRow);
        // System.out.println(sameCol);

        Set<String> visited = new HashSet<>();

        int safe = 0;
        for (int i = 0; i < n; i++) {
            int x = stones[i][0];
            int y = stones[i][1];
            String point = x + "," + y;
            if (!visited.contains(point)) {
                safe += 1;
                dfs(x, y, sameRow, sameCol, visited);
                // System.out.println("x: " + x + ", y: " + y);
            }
        }

        return n - safe;
    }


    private void dfs(int x, int y, Map<Integer, ArrayList<Integer>> sameRow, Map<Integer, ArrayList<Integer>> sameCol, Set<String> visited) {
        String point = x + "," + y;
        visited.add(point);

        ArrayList<Integer> rowNeighbours = sameRow.get(y);
        for (int i = 0; i < rowNeighbours.size(); i++) {
            int nx = rowNeighbours.get(i);
            String nextPoint = nx + "," + y;

            if (!visited.contains(nextPoint)) {
                dfs(nx, y, sameRow, sameCol, visited);
            }
        }

        ArrayList<Integer> colNeighbours = sameCol.get(x);
        for (int i = 0; i < colNeighbours.size(); i++) {
            int ny = colNeighbours.get(i);
            String nextPoint = x + "," + ny;

            if (!visited.contains(nextPoint)) {
                dfs(x, ny, sameRow, sameCol, visited);
            }
        }
    }
}