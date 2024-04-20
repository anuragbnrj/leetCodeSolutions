class Solution {
public:
    int countCompleteComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n, vector<int>(0));
        vector<bool> visited(n, false);

        for (int i = 0; i < edges.size(); i++) {
            addUndirectedEdge(graph, edges[i][0], edges[i][1]);
        }

        vector<int> component;
        int res = 0;
        for (int i = 0; i < n; i++) {
            
            if (!visited[i]) {
                vector<int> component;
                dfs(i, graph, visited, component);

                bool flag = true; 
                for (int j = 0; j < component.size(); j++) {
                    if (graph[component[j]].size() != ((int)component.size() - 1)) {
                        // cout << i << " " << component[j] << " " << graph[component[j]].size() << " " << ((int)component.size() - 1) << endl;
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    res += 1;
                }
            }
        }

        return res;
    }

private:
    void dfs(int src, vector<vector<int>> &graph, vector<bool> &visited, vector<int> &component) {
        visited[src] = true;
        component.push_back(src);

        for (int next : graph[src]) {
            if (!visited[next]) {
                dfs(next, graph, visited, component);
            }
        }
    }

    void addUndirectedEdge(vector<vector<int>> &graph, int src, int des) {
        graph[src].push_back(des);
        graph[des].push_back(src);
    }
};