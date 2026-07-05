class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adjList.get(u).add(new int[]{v, w});
            adjList.get(v).add(new int[]{u, w});
        }

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        pq.offer(new int[]{1, 0});
        visited[1] = true;

        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int curr = top[0];
            
            for (int[] edge : adjList.get(curr)) {
                int next = edge[0];
                int weight = edge[1];

                ans = Math.min(ans, weight);

                if (!visited[next]) {
                    pq.offer(new int[]{next, weight});
                    visited[next] = true;
                }
            }
        }

        return ans;
    }
}