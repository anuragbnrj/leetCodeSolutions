class Solution {

    public int minCost(int n, int[][] edges) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            g[u].add(new int[] {v, w });
            g[v].add(new int[] {u, 2 * w });
        }

        int[] d = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        pq.offer(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            int[] front = pq.poll();
            int dist = front[0];
            int node = front[1];

            if (node == n - 1) {
                return dist;
            }

            if (visited[node]) {
                continue;
            }
            visited[node] = true;

            for (int[] neighbor : g[node]) {
                int next = neighbor[0];
                int w = neighbor[1];

                if (dist + w < d[next]) {
                    d[next] = dist + w;
                    pq.offer(new int[] {d[next], next});
                }
            }
        }

        return -1;
    }
}