class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int rows = board.size();
        int cols = board[0].size();

        bool res = false;
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                res = res || solve(r, c, 0, visited, board, word);
            }
        }

        return res;
    }

private:
    bool solve(int r, int c, int idx, vector<vector<bool>> &visited, vector<vector<char>> &board, string word) {
        if ((idx == word.size() - 1) && board[r][c] == word[idx]) {
            return true;
        }

        int rows = board.size();
        int cols = board[0].size();

        int dr[] = {-1, 0, 0, 1};
        int dc[] = {0, -1, 1, 0};

        bool res = false;
        if(board[r][c] == word[idx]) {
            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isValidCell(nr, nc, rows, cols) && !visited[nr][nc]) {
                    res = res || solve(nr, nc, idx + 1, visited, board, word);
                }
            }
            visited[r][c] = false;
        }

        return res;
    }

    bool isValidCell(int r, int c, int rows, int cols) {
        if (r < 0 || rows - 1 < r) {
            return false;
        }

        if (c < 0 || cols - 1 < c) {
            return false;
        }

        return true;
    }
};