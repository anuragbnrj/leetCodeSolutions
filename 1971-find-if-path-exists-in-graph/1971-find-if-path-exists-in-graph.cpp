class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<vector<int>> graph(n, vector<int>(0));

        for (int i = 0; i < edges.size(); i++) {
            addEdge(graph, edges[i][0], edges[i][1]);
        }

        vector<bool> visited(n, false);
        bool res = isPossible(graph, visited, source, destination);

        return res;
    }

private:
    bool isPossible(vector<vector<int>> &graph, vector<bool> &visited, int src, int des) {
        visited[src] = true;

        bool res = false;
        for (int i = 0; i < graph[src].size() && !res; i++) {
            if (graph[src][i] == des) {
                res = true;
                break;
            }

            if (!visited[graph[src][i]]) {
                res = res || isPossible(graph, visited, graph[src][i], des);
            }
            
        }

        return res;
    }

    void addEdge(vector<vector<int>> &graph, int src, int des) {
        graph[src].push_back(des);
        graph[des].push_back(src);
    }
};