class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int xr = 0;
        for (int n : nums) {
            xr = xr ^ n;
        }

        int lastSetBit = __builtin_ctz(xr);

        vector<int> gr1;
        vector<int> gr2;

        for (int n : nums) {
            if (((n >> lastSetBit) & 1) == 1) {
                gr2.push_back(n);
            } else {
                gr1.push_back(n);
            }
        }

        vector<int> res;
        xr = 0;
        for (int n : gr1) {
            xr = xr ^ n;
        }
        res.push_back(xr);

        xr = 0;
        for (int n : gr2) {
            xr = xr ^ n;
        }
        res.push_back(xr);

        return res;
    }
};