class Solution {
    public int findCircleNum(int[][] isConnected) {
        int vertices = isConnected.length;
        boolean[] visited = new boolean[vertices];

        int provinces = 0;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                provinces += 1;
                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int v, int[][] isConnected, boolean[] visited) {
        visited[v] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if ((isConnected[v][i] == 1) && !visited[i]) {
                dfs(i, isConnected, visited);
            }
        }
    }
}