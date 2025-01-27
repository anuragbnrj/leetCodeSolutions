class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adjList[u].add(v);
            indegree[v] += 1;
        }
        
        Set<Integer>[] dependentOn = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dependentOn[i] = new HashSet<>();
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                dependentOn[i] = new HashSet<>();
            }
        }

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                int front = q.poll();

                for (int neigh : adjList[front]) {
                    Set<Integer> existing = dependentOn[neigh];
                    existing.addAll(dependentOn[front]);
                    existing.add(front);

                    indegree[neigh] -= 1;

                    if (indegree[neigh] == 0) {
                        q.offer(neigh);
                    }
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];

            if (dependentOn[v].contains(u)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}