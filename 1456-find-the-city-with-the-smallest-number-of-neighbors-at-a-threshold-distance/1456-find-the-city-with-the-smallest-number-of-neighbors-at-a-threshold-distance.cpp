class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {

        vector<vector<int>> graph(n, vector<int>(n, 1e9));

        for (int i = 0; i < edges.size(); i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int w = edges[i][2];
            graph[from][to] = w;
            graph[to][from] = w;
        }

        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }


        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int mnCount = INT_MAX;
        int mnCity = INT_MIN;
        for (int i = 0; i < n; i++) {
            int ctr = 0;
            for (int j = 0; j < n; j++) {
                // cout << graph[i][j] << "\t";
                if (graph[i][j] <= distanceThreshold) {
                    ctr++;
                }
            }

            // cout << endl;

            if (ctr <= mnCount) {
                mnCount = ctr;
                mnCity = i;
            }
        }

        return mnCity;
    }
};