class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        vector<int> won(100005, 0);
        vector<int> lost(100005, 0);
        vector<int> played(100005, 0);

        int len = matches.size();
        for (int i = 0; i < len; i++) {
            int pl1 = matches[i][0];
            int pl2 = matches[i][1];
            won[pl1]++;
            lost[pl2]++;
            played[pl1]++;
            played[pl2]++;
        }

        vector<vector<int>> res(2);
        for (int i = 0; i < 100005; i++) {
            if (played[i] > 0 && lost[i] == 0) {
                res[0].push_back(i);
            }

            if (played[i] > 0 && lost[i] == 1) {
                res[1].push_back(i);
            }
        }

        return res;
    }
};