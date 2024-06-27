class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        int nodes = edges.size() + 1;

        vector<int> degree(nodes + 1);
        for (auto edge : edges) {
            int u = edge[0];
            int v = edge[1];

            degree[u]++;
            degree[v]++;
        }

        int ans = 0;
        for (int i = 1; i <= nodes; i++) {
            if (degree[i] == nodes - 1) {
                ans = i;
                break;
            }
        }

        return ans;
    }
};