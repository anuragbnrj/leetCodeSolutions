class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int rows = board.size();
        int cols = board[0].size();
        
        bool exists = false;
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        for (int r = 0; r < rows && !exists; r++) {
            for (int c = 0; c < cols && !exists; c++) {
                exists = exists || isPresent(board, r, c, word, 0, visited, rows, cols);
            }
        }

        return exists;
    }

private:
    bool isPresent(vector<vector<char>> &board, int r, int c, string word, int idx, 
    vector<vector<bool>> &visited, int rows, int cols) {
        if (idx == word.size() - 1 && board[r][c] == word[idx]) {
            return true;
        }

        if (board[r][c] != word[idx]) {
            return false;
        }

        visited[r][c] = true;

        int dr[] = {-1, 0, 0, 1};
        int dc[] = {0, -1, 1, 0};

        bool res = false;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isOk(nr, nc, rows, cols) && !visited[nr][nc]) {
                res = res || isPresent(board, nr, nc, word, idx + 1, visited, rows, cols);
            }
        }

        visited[r][c] = false;

        return res;
    }

    bool isOk(int r, int c, int rows, int cols) {
        if (r < 0 || rows <= r) {
            return false;
        }

        if (c < 0 || cols <= c) {
            return false;
        }

        return true;
    }
};