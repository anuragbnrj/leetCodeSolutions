class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            indegree[v] += 1;
        }

        int countZeroIndegree = 0;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                res = i;
                countZeroIndegree += 1;
            }
        }

        if (countZeroIndegree == 1) {
            return res;
        }
        return -1;
    }
}