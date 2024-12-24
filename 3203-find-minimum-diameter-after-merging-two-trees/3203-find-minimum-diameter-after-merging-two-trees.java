class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int dia1 = getDiameter(edges1);
        int dia2 = getDiameter(edges2);

        int ans = Math.max(dia1, dia2);
        ans = Math.max(ans, ((dia1 + 1) / 2) + 1 + ((dia2 + 1) / 2));

        return ans;
    }

    private int getDiameter(int[][] edges) {
        int nodes = edges.length + 1;
        ArrayList<Integer>[] adjList = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        
        int[] temp = getFarthestNodeAndDistance(0, adjList);
        temp = getFarthestNodeAndDistance(temp[0], adjList);

        return temp[1];
    }

    private int[] getFarthestNodeAndDistance(int src, ArrayList<Integer>[] adjList) {
        int startNode = src;
        int currentLevel = 0;
        int farthestNode = 0;
        int maxLevel = -1;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        boolean[] visited = new boolean[adjList.length];
        visited[src] = true;
        while (q.size() > 0) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                int front = q.poll();
                visited[front] = true;

                for (int neighbour : adjList[front]) {
                    if (!visited[neighbour]) {
                        q.offer(neighbour);
                    }
                }

                if (currentLevel >= maxLevel) {
                    maxLevel = currentLevel;
                    farthestNode = front;
                }
            }

            currentLevel += 1;
        }

        return new int[]{farthestNode, maxLevel};
    }
}