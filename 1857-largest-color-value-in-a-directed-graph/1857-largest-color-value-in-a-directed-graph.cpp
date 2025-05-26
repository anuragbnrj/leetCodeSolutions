class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        int n = colors.size();
        vector<vector<int>> graph(n);
        vector<int> indegree(n, 0);
        vector<vector<int>> sumCol(n, vector<int>(26, 0));

        for (auto edge : edges) {
            int from = edge[0];
            int to = edge[1];
            addDirectedEdge(from, to, graph);
            indegree[to] += 1;
        }

        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }

        int popped = 0;
        int res = -1;
        while (!q.empty()) {
            int front = q.front(); 
            q.pop();
            popped++;
            int color = colors[front] - 'a';

            sumCol[front][color] += 1;
            res = max(res, sumCol[front][color]);


            for (int adj : graph[front]) {
                indegree[adj] -= 1;

                if (indegree[adj] == 0) {
                    q.push(adj);
                }

                for (int i = 0; i < 26; i++) {
                    sumCol[adj][i] = max(sumCol[adj][i], sumCol[front][i]);
                }
            }
        }

        if (popped != n) {
            return -1;
        }

        return res;
    }

private:
    void addDirectedEdge(int from, int to, vector<vector<int>>& graph) {
        graph[from].push_back(to);
    }
};