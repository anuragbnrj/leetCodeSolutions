class Solution {
public:
    vector<int> lexicalOrder(int n) {
        vector<int> res;
        for (int i = 1; i <= 9 && i <= n; i++) {
            dfs(i, n, res);
        }

        return res;
    }

private:
    void dfs(int curr, int n, vector<int> &res) {
        res.push_back(curr);

        for (int i = 0; i <= 9; i++) {
            if (curr * 10 + i <= n) {
                dfs(curr * 10 + i, n, res);
            }
        }
    }
}; 