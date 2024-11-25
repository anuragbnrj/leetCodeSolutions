class Solution {
public:
    int slidingPuzzle(vector<vector<int>>& board) {
        string str(6, '0');
        str[0] += board[0][0];
        str[1] += board[0][1];
        str[2] += board[0][2];
        str[3] += board[1][0];
        str[4] += board[1][1];
        str[5] += board[1][2];

        queue<string> q;
        q.push(str);
        unordered_set<string> visited;
        visited.insert(str);

        int dr[] = {-1, 0, 0, 1};
        int dc[] = {0, -1, 1, 0};

        for (int level = 0, sz = q.size(); !q.empty(); level++, sz = q.size()) {

            while(sz--) {
                string front = q.front();
                q.pop();
                // string temp = front;

                // cout << "front: " << front << endl;
                
                if (front == "123450") {
                    return level;
                }

                int row, col, pos;
                vector<vector<char>> arr(2, vector<char>(3, '0'));
                arr[0][0] = front[0]; if (front[0] == '0') {row = 0; col = 0; pos = 0;}
                arr[0][1] = front[1]; if (front[1] == '0') {row = 0; col = 1; pos = 1;}
                arr[0][2] = front[2]; if (front[2] == '0') {row = 0; col = 2; pos = 2;}
                arr[1][0] = front[3]; if (front[3] == '0') {row = 1; col = 0; pos = 3;}
                arr[1][1] = front[4]; if (front[4] == '0') {row = 1; col = 1; pos = 4;}
                arr[1][2] = front[5]; if (front[5] == '0') {row = 1; col = 2; pos = 5;}

                for (int i = 0; i < 4; i++) {
                    int nr = row + dr[i];
                    int nc = col + dc[i];

                    if (is_valid(nr, nc)) {
                        int t = arr[row][col];
                        arr[row][col] = arr[nr][nc];
                        arr[nr][nc] = t;

                        front[0] = arr[0][0];
                        front[1] = arr[0][1];
                        front[2] = arr[0][2];
                        front[3] = arr[1][0];
                        front[4] = arr[1][1];
                        front[5] = arr[1][2];

                        if (visited.count(front) == 0) {
                            q.push(front);
                            visited.insert(front);
                        }

                        t = arr[row][col];
                        arr[row][col] = arr[nr][nc];
                        arr[nr][nc] = t;
                    }
                }

            }
        }

        return -1;
    }

private:
    bool is_valid(int row, int col) {
        if (row < 0 || row > 1) {
            return false;
        }

        if (col < 0 || col > 2) {
            return false;
        }

        return true;
    }
};