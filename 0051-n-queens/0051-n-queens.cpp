class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<vector<bool>> isQueen(n, vector<bool>(n, false));
        solve(0, isQueen, res);

        return res;
    }

private:
    void solve(int r, vector<vector<bool>> &isQueen, vector<vector<string>> &res) {
        if (r == isQueen.size()) {
            addToResult(isQueen, res);
            return;
        }

        for (int c = 0; c < isQueen[0].size(); c++) {
            if (tryPlacing(r, c, isQueen)) {
                isQueen[r][c] = true;
                solve(r + 1, isQueen, res);
                isQueen[r][c] = false;
            }
        }
    }

    bool tryPlacing(int r, int c, vector<vector<bool>> &isQueen) {
        // check same column
        for (int i = r - 1; i >= 0; i--) {
            if (isQueen[i][c]) {
                return false;
            }
        }

        // check upper left diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (isQueen[i][j]) {
                return false;
            }
        }

        // check upper right diagonal
        for (int i = r - 1, j = c + 1; i >=0 && j < isQueen[0].size(); i--, j++) {
            if (isQueen[i][j]) {
                return false;
            }
        }

        // return true when all conditions are satisfied
        return true;
    }

    void addToResult(vector<vector<bool>> &isQueen, vector<vector<string>> &res) {
        vector<string> arr;
        for (int r = 0; r < isQueen.size(); r++) {
            string str = "";
            for (int c = 0; c < isQueen[0].size(); c++) {
                if (isQueen[r][c]) {
                    str = str + "Q";
                } else {
                    str = str + ".";
                }
            }
            arr.push_back(str);
        }

        res.push_back(arr);
    }
};
