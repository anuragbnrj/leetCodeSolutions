#include <iostream>
#include <vector>

using namespace std;

vector<vector<bool>> isQueen;

class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        isQueen.resize(n);
        for (int i = 0; i < n; i++) {
            isQueen[i].resize(n);
        }
        solve(0, res);

        return res;
    }

private:
    void solve(int r, vector<vector<string>> &res) {
        if (r == isQueen.size()) {
            addToResult(res);
            return;
        }

        for (int c = 0; c < isQueen[0].size(); c++) {
            if (tryPlacing(r, c)) {
                isQueen[r][c] = true;
                solve(r + 1, res);
                isQueen[r][c] = false;
            }
        }
    }

    bool tryPlacing(int r, int c) {
        // cout << "Inside tryPlacing r : " << r << "\t c: " << c ;
        // check same column
        for (int i = r - 1; i >= 0; i--) {
            if (isQueen[i][c]) {
                // cout << "\t returning false" << endl;
                return false;
            }
        }

        // check upper left diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (isQueen[i][j]) {
                // cout << "\t returning false" << endl;
                return false;
            }
        }

        // check upper right diagonal
        for (int i = r - 1, j = c + 1; i >=0 && j < isQueen[0].size(); i--, j++) {
            if (isQueen[i][j]) {
                // cout << "\t returning false" << endl;
                return false;
            }
        }

        // return true when all conditions are satisfied
        // cout << "\t returning true" << endl;
        return true;
    }

    void addToResult(vector<vector<string>> &res) {
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
