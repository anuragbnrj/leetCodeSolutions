class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n);
        vector<int> indegree(n, 0);
        for (auto edge : edges) {
            int src = edge[0];
            int des = edge[1];

            indegree[des] += 1;
            graph[src].push_back(des);
        }

        vector<int> visited(n, 0);
        vector<vector<int>> ancestors(n, vector<int>(0));
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                vector<int> prev;
                dfs(i, graph, prev, ancestors);
            }
        }

        vector<vector<int>> isParent(n + 1, vector<int>(n + 1, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < ancestors[i].size(); j++) {
                isParent[i][ancestors[i][j]] = 1;
            }
        }

        vector<vector<int>> ans(n, vector<int>(0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isParent[i][j] == 1) {
                    ans[i].push_back(j);
                }
            }
        }

        return ans;
    }

private:
    void dfs(int src, vector<vector<int>> &graph, vector<int> &prev, vector<vector<int>> &ancestors) {
        if (prev.size() != 0) {
            ancestors[src].insert(ancestors[src].end(), prev.begin(), prev.end());
        }

        prev.push_back(src);

        for (int neigh : graph[src]) {
            dfs(neigh, graph, prev, ancestors);
        }

        prev.pop_back();
    }
};