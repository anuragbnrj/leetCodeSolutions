class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        int prev = 0;
        int res = 0;

        for (int i = 0; i < bank.size(); i++) {
            int curr = 0;
            for (int j = 0; j < bank[i].size(); j++) {
                if (bank[i][j] == '1') {
                    curr++;
                }
            }

            if (curr > 0) {
                res = res + (curr * prev);
                prev = curr;
            }
        }

        return res;
    }
};