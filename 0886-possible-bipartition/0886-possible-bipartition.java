class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : dislikes) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            adjList[u].add(v);
            adjList[v].add(u);
        }

        boolean possible = true;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                possible = possible && isForestBipartite(i, adjList, visited, 0);
            }

            if (!possible) break;
        }

        return possible;
    }

    private boolean isForestBipartite(int curr, List<Integer>[] adjList, int[] visited, int currColor) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(curr);
        visited[curr] = currColor;

        while (q.size() > 0) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                int front = q.poll();
                for (int neigh : adjList[front]) {
                    if (visited[neigh] == visited[front]) return false;

                    if (visited[neigh] != -1) continue;

                    q.offer(neigh);
                    visited[neigh] = (visited[front] + 1) % 2;
                }
            }
        }
        
        return true;
    }
}