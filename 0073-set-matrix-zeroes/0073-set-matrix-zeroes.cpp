class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        set<int> zrows;
        set<int> zcols;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    zrows.insert(r);
                    zcols.insert(c);
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (zrows.count(r) || zcols.count(c)) {
                    matrix[r][c] = 0;
                }
            }
        }
    
    }
};