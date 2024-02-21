class Solution {
public:
    int rangeBitwiseAnd(int left, int right) {
        vector<int> lbits(31, 0);
        vector<int> rbits(31, 0);
        for (int bit = 0; bit < 31; bit++) {
            lbits[bit] = ((left >> bit) & 1);
            rbits[bit] = ((right >> bit) & 1);
        }

        vector<int> res(31, 0);
        for (int bit = 0; bit < 31; bit++) {
            if (lbits[bit] == 1 && rbits[bit] == 1) {
                if ((right - left) > pow(2, bit)) {
                    res[bit] = 0;
                } else {
                    res[bit] = 1;
                }
            } else {
                res[bit] = 0;
            }
        }

        long long ans = 0;
        for (int bit = 0; bit < 31; bit++) {
            // cout << res[bit] << " ";
            ans += ((1 << bit) * res[bit]);
        }

        return ans;
    }
};