class Solution {
    private int INF = (int) 1e9;
    List<int[]>[] graph;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (w != -1) {
                graph[u].add(new int[]{v, w});
                graph[v].add(new int[]{u, w});
            }
        }

        int shortestPathNoModify = dijkstra(n, source, destination);
        if (shortestPathNoModify < target) {
            return new int[0][0];
        }

        boolean matchesTarget = (shortestPathNoModify == target);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (w != -1) continue;
            
            w = matchesTarget ? INF : 1;
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
            edge[2] = w;

            if (!matchesTarget) {
                int newDist = dijkstra(n, source, destination);

                if (newDist <= target) {
                    int diff = target - newDist;
                    matchesTarget = true;
                    edge[2] += diff;
                }
            }
        }

        return matchesTarget ? edges : new int[0][0];
    }

    private int dijkstra(int n, int src, int des) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        dist[src] = 0;
        pq.offer(new int[]{src, 0});
        while (pq.size() > 0) {
            int[] top = pq.poll();
            
            int currDist = top[1];
            int curr = top[0];

            if (visited[curr] == true) continue;
            visited[curr] = true;

            for (int[] edge : graph[curr]) {
                int next = edge[0];
                int wt = edge[1];

                if (dist[next] > currDist + wt) {
                    dist[next] = currDist + wt;
                    pq.offer(new int[]{next, dist[next]});
                }
            }  
        }

        return dist[des];
    }
}