class Solution {
public:
    int res = INT_MAX;
    set<pair<int, int>> zeroes;
   
    int minimumMoves(vector<vector<int>>& grid) {
        int rows = 3;
        int cols = 3;
        
        vector<pair<int, int>> zeroes;
        vector<pair<int, int>> multis;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int curr = grid[i][j];
                if (curr == 0) {
                    zeroes.emplace_back(make_pair(i, j));
                } else {
                    for (int k = 1; k < curr; k++) {
                        multis.emplace_back(make_pair(i, j));
                    }
                }
            }
        }


        do {
            int totMoves = 0;
            for (int i = 0; i < zeroes.size(); i++) {
                totMoves += (abs(zeroes[i].first - multis[i].first) + abs(zeroes[i].second - multis[i].second));
            }

            res = min(res, totMoves);
        } while (next_permutation(zeroes.begin(), zeroes.end()));


        return res;   
    }

};