class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<Integer> rowTopo = kahns(k, rowConditions);
        ArrayList<Integer> colTopo = kahns(k, colConditions);

        if (rowTopo.size() != k || colTopo.size() != k) {
            return new int[0][0];
        }

        int[] rowPos = new int[k + 1];
        for (int i = 0; i < rowTopo.size(); i++) {
            int el = rowTopo.get(i);
            rowPos[el] = i;
        }

        int[] colPos = new int[k + 1];
        for (int i = 0; i < colTopo.size(); i++) {
            int el = colTopo.get(i);
            colPos[el] = i;
        }

        int[][] ans = new int[k][k];
        for (int i = 1; i <= k; i++) {
            int r = rowPos[i];
            int c = colPos[i];

            ans[r][c] = i;
        }

        return ans;
    }

    private ArrayList<Integer> kahns(int nodes, int[][] edges) {
        int[] indegree = new int[nodes + 1];
        ArrayList<Integer>[] adjList = new ArrayList[nodes + 1];
        for (int i = 0; i <= nodes; i++) {
            adjList[i] = new ArrayList<>();
        }

        boolean[][] processed = new boolean[nodes + 1][nodes + 1];

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            if (processed[from][to] == false) {
                adjList[from].add(to);
                indegree[to] += 1;
                processed[from][to] = true;
            }
        }
        // debug(adjList);
        
        // for (int i = 1; i <= nodes; i++) {
        //     System.out.println("Neighbours of " + i);
        //     for (Integer neigh : adjList[i]) {
        //         System.out.println(" " + neigh);
        //     }
        // }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= nodes; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topoSort = new ArrayList<>();
        while (q.size() > 0) {
            int front = q.peek();
            q.poll();
            topoSort.add(front);
            
            for (Integer neigh : adjList[front]) {
                indegree[neigh] -= 1;
                if (indegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }

        return topoSort;
    }

    public static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}