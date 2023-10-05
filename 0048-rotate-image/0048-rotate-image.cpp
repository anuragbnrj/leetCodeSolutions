class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        for (int r = 0; r < rows / 2; r++) {
            for (int c = 0; c < cols; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[rows - 1 - r][c];
                matrix[rows - 1 - r][c] = temp;
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = r; c < cols; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }
};