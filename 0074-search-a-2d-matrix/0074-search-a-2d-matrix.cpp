class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        int beg = 0;
        int end = rows * cols;
        while (beg < end) {
            int mid = beg + ((end - beg) / 2);

            // cout << beg << "\t " << mid << "\t " << end << endl;

            if (mid == rows * cols) {
                return false;
            }

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] < target) beg = mid + 1;
            else end = mid;
        }

        // cout << "beg: " << beg << endl;

        if (beg == rows * cols) {
            return false;
        }

        int row = beg / cols;
        int col = beg % cols;

        if (matrix[row][col] == target) {
            return true;
        }

        return false;
    }
};