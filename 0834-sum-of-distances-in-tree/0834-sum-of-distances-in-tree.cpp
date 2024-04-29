class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, -1));

        vector<vector<int>> graph(n, vector<int>(0));

        for (int i = 0; i < edges.size(); i++) {
            addEdge(graph, edges[i][0], edges[i][1]);
        }

        vector<int> rootedAt(n, 0);
        vector<bool> visited(n, false);
        vector<int> distanceSum(n, 0);

        dfs(graph, visited, rootedAt, distanceSum, 0, 0);

        // for (int i = 0; i < n; i++) {
        //     cout << rootedAt[i] << "\t";
        // }
        // cout << endl;

        for (auto next : graph[0]) {
            findDist(graph, rootedAt, distanceSum, 0, next);
        }

        return distanceSum;
    }

private:
    void findDist(vector<vector<int>>& graph, vector<int>& rootedAt,
                  vector<int>& distanceSum, int parent, int src) {
        distanceSum[src] = distanceSum[parent] - (rootedAt[src] - 1) +
                           ((int)graph.size() - rootedAt[src] - 1);

        for (auto next : graph[src]) {
            if (next != parent) {
                findDist(graph, rootedAt, distanceSum, src, next);
            }
        }
    }

    int dfs(vector<vector<int>>& graph, vector<bool>& visited,
            vector<int>& rootedAt, vector<int>& distanceSum, int src,
            int level) {
        visited[src] = true;
        distanceSum[0] += level;

        int nodesAt = 1;
        for (auto next : graph[src]) {
            if (!visited[next]) {
                nodesAt +=
                    dfs(graph, visited, rootedAt, distanceSum, next, level + 1);
            }
        }

        rootedAt[src] = nodesAt;

        return rootedAt[src];
    }

    void addEdge(vector<vector<int>>& graph, int src, int des) {
        graph[src].push_back(des);
        graph[des].push_back(src);
    }
};