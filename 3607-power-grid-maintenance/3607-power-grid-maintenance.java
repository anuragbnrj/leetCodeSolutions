class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<TreeSet<Integer>> gridMembers = new ArrayList<>();

        List<Integer>[] adjList = new ArrayList[c];
        for (int i = 0; i < c; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] conn : connections) {
            int u = conn[0] - 1;
            int v = conn[1] - 1;

            adjList[u].add(v);
            adjList[v].add(u);
        }

        int[] gridNumberMapping = new int[c];
        Arrays.fill(gridNumberMapping, -1);
        int gridNum = 0;
        for (int i = 0; i < c; i++) {
            if (gridNumberMapping[i] == -1) {
                bfs(i, gridNumberMapping, adjList, gridMembers, gridNum);
                gridNum += 1;
            }
        }

        boolean[] isOnline = new boolean[c];
        Arrays.fill(isOnline, true);

        // System.out.println(gridMembers.toString());
        List<Integer> ansList = new ArrayList<>();
        for (int[] query : queries) {
            int type = query[0];
            int station = query[1] - 1;

            System.out.println(Arrays.toString(query));
            if (type == 1) {
                if (isOnline[station]) {
                    ansList.add(station + 1);
                } else {
                    int operationalStation = -1;
                    if (!gridMembers.get(gridNumberMapping[station]).isEmpty()) {
                        operationalStation = gridMembers.get(gridNumberMapping[station]).first() + 1;
                    }
                    ansList.add(operationalStation);
                }
            }

            if (type == 2) {
                isOnline[station] = false;
                gridMembers.get(gridNumberMapping[station]).remove(station);
            }
        }

        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }

    private void bfs(int src, int[] gridNumberMapping, List<Integer>[] adjList, List<TreeSet<Integer>> gridMembers, int gridNum) {
        TreeSet<Integer> members = new TreeSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int front = q.poll();
            gridNumberMapping[front] = gridNum;
            members.add(front);

            for (int neigh : adjList[front]) {
                if (gridNumberMapping[neigh] == -1) {
                    q.add(neigh);
                }
            }

        }

        gridMembers.add(members);
    }
}