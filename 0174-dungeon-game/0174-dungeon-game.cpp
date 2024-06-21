class Solution {
public:
    int mostMinInPath[210][210];
    int energyAt[210][210];

    int calculateMinimumHP(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();

        mostMinInPath[0][0] = grid[0][0];
        energyAt[0][0] = grid[0][0];
        for (int c = 1; c < m; c++) {
            energyAt[0][c] = energyAt[0][c - 1] + grid[0][c];
            mostMinInPath[0][c] = min(mostMinInPath[0][c - 1], energyAt[0][c]);
        }
        for (int r = 1; r < n; r++) {
            energyAt[r][0] = energyAt[r - 1][0] + grid[r][0];
            mostMinInPath[r][0] = min(mostMinInPath[r - 1][0], energyAt[r][0]);
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                int energyFromLeft = energyAt[r][c - 1] + grid[r][c];
                int minFromLeft = min(mostMinInPath[r][c - 1], energyFromLeft);

                int energyFromUp = energyAt[r - 1][c] + grid[r][c];
                int minFromUp = min(mostMinInPath[r - 1][c], energyFromUp);

                if (minFromLeft < minFromUp) {
                    energyAt[r][c] = energyFromUp;
                    mostMinInPath[r][c] = minFromUp;
                } else {
                    energyAt[r][c] = energyFromLeft;
                    mostMinInPath[r][c] = minFromLeft;
                }
            }
        }

        if (mostMinInPath[n - 1][m - 1] <= 0) {
            // cout << (mostMinInPath[n - 1][m - 1] * -1) + 1 << endl;
            return ((mostMinInPath[n - 1][m - 1] * -1) + 1);
        } else {
            // cout << "1" << endl;
            return 1;
        }
    }
};