class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        int beg = 0; 
        int end = rows - 1;
        int row = -1;
        while (beg <= end) {
            int mid = beg + ((end - beg) / 2);

            if (matrix[mid][0] <= target && target <= matrix[mid][cols - 1]) {
                row = mid;
                break;
            } else if (target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        if (row == -1) {

            return false;
        }


        beg = 0; 
        end = cols - 1;
        int col = -1;
        while (beg <= end) {
            int mid = beg + ((end - beg) / 2);

            if (matrix[row][mid] == target) {
                col = mid;
                break;
            } else if (target < matrix[row][mid]) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        if (col == -1) {
            return false;
        } else { 
            return true;
        }
    }

};