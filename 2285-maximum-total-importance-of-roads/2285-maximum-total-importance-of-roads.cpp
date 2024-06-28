class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        vector<int> degree(n, 0);

        for (auto road : roads) {
            int u = road[0];
            int v = road[1];

            degree[u] += 1;
            degree[v] += 1;
        }

        sort(degree.begin(), degree.end());

        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (1LL * degree[i] * (i + 1));
        }

        return ans;
    }
};