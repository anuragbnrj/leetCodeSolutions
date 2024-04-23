class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        if (n == 1) {
            return {0};
        }

        vector<vector<int>> graph(n);
        vector<int> indegree(n, 0);
        for (int i = 0; i < edges.size(); i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            graph[from].push_back(to);
            graph[to].push_back(from);

            indegree[from] += 1;
            indegree[to] += 1;
        }

        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.push(i);
            }
        }

        for (int sz = n; sz > 2;) {
            int leaves = q.size();
            sz -= leaves;
            // cout << "size: " << sz << endl;

            while (leaves--) {
                int front = q.front(); q.pop();

                // cout << "front: " << front << endl;
                
                for (int adj : graph[front]) {
                    indegree[front] -= 1;
                    indegree[adj] -= 1;

                    if (indegree[adj] == 1) {
                        q.push(adj);
                    }
                }
            }
        }

        vector<int> res;
        while (!q.empty()) {
            int front = q.front();
            q.pop();

            res.push_back(front);
        }
        

        return res;
    }

};