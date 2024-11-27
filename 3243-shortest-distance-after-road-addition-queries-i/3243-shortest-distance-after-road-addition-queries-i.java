class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();

            if (i != (n - 1)) {
                adjList[i].add(i + 1);
            }
        }

        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];

            adjList[u].add(v);

            int minDist = getMinDist(0, n - 1, n, adjList);
            ans[q] = minDist;
        }

        return ans;
    }

    private int getMinDist(int src, int des, int n, List<Integer>[] adjList) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(src);
        visited[src] = true;
    
        int currDist = 0;
        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                int front = q.poll();
                if (front == des) {
                    return currDist;
                }

                for (int neigh : adjList[front]) {
                    if (!visited[neigh]) {
                        q.offer(neigh);
                        visited[neigh] = true;
                    }
                }

            }

            currDist += 1;
        }

        return -1;
    }
}