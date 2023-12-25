class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        int fillCount = 0;
        bool printed = false;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    fillCount++;
                }
            }
        }

        solve(fillCount, board);

        // print the soduku solution
        // for (int i = 0; i < 9; i++) {
        //     for (int j = 0; j < 9; j++) {
        //         cout << board[i][j] << "\t";
        //     }
        //     cout << endl;
        // }
        
    }

private:
       bool solve(int fillCount, vector<vector<char>>& board) {
        if (fillCount == 81) {
            return true;
        }

        int emptyRow, emptyCol;
        bool exitLoop = false;
        for (int i = 0; i < 9 && !exitLoop; i++) {
            for (int j = 0; j < 9 && !exitLoop; j++) {
                if (board[i][j] == '.') {
                    emptyRow = i;
                    emptyCol = j;
                    exitLoop = true;
                }
            }
        }

        bool solved = false;
        for (int k = 1; k <= 9 && !solved; k++) {
            char ch = '0' + k;
            if (canBePlaced(ch, emptyRow, emptyCol, board)) {
                board[emptyRow][emptyCol] = ch;
                solved = solve(fillCount + 1, board);
                if (solved) {
                    return true;
                }
                board[emptyRow][emptyCol] = '.';
            }
        }

        return false;
    }

    bool canBePlaced(char k, int i, int j, vector<vector<char>>& board) {
        // check same row
        for (int c = 0; c < 9; c++) {
            if (board[i][c] == k) {
                return false;
            }
        }

        // check same column
        for (int r = 0; r < 9; r++) {
            if (board[r][j] == k) {
                return false;
            }
        }

        // check in its own box
        pair<int, int> rowBoundary = getStartAndEnd(i);
        pair<int, int> colBoundary = getStartAndEnd(j);
        for (int r = rowBoundary.first; r <= rowBoundary.second; r++) {
            for (int c = colBoundary.first; c <= colBoundary.second; c++) {
                if (board[r][c] == k) {
                    return false;
                }
            }
        }

        // if all the above conditions are false then return true
        return true;
    }

    pair<int, int> getStartAndEnd(int n) {
        pair<int, int> res;
        if (0 <= n && n <= 2) {
            res.first = 0;
            res.second = 2;
        } else if (3 <= n && n <= 5) {
            res.first = 3;
            res.second = 5;
        } else {
            res.first = 6;
            res.second = 8;
        }

        return res;
    }
};