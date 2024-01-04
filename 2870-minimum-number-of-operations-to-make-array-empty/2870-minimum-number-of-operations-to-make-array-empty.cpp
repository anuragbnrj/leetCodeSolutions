class Solution {
public:
    int minOperations(vector<int>& nums) {
        map<int, int> mpp;

        for (int el : nums) {
            mpp[el] += 1;
        }

        int res = 0;
        for (auto el : mpp) {
            int freq = el.second;
            if (freq == 1) {
                return -1;
            }

            if (freq % 3 == 1) {
                res = res + ((freq - 4) / 3) + 2;
            } else if (freq % 3 == 2) {
                res = res + ((freq - 2) / 3) + 1;
            } else {
                res = res + (freq / 3);
            }
        }
        

        return res;
    }
};