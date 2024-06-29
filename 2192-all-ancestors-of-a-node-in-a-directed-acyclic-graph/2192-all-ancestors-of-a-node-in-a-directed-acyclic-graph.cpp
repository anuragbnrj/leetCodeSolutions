class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n);
        for (auto edge : edges) {
            int src = edge[0];
            int des = edge[1];

            graph[src].push_back(des);
        }

        vector<vector<int>> ans(n);
        for (int i = 0; i < n; i++) {
            vector<int> visited(n, 0);
            dfs(i, i, graph, visited, ans);
        }

        return ans;
    }

private:
    void dfs(int src, int initParent, vector<vector<int>> &graph, vector<int> &visited, vector<vector<int>> &ans) {
        visited[src] = 1;

        if (initParent != src) {
            ans[src].push_back(initParent);
        }

        for (int neigh : graph[src]) {
            if (visited[neigh] == 0) {
                dfs(neigh, initParent, graph, visited, ans);
            }
        }
    }
};