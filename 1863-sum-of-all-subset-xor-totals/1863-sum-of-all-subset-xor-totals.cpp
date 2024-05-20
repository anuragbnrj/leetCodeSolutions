class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        int n = nums.size();

        int res = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int tempXr = 0;
            for (int bit = 0; bit < n; bit++) {
                if ((mask >> bit) & 1) {
                    tempXr = tempXr ^ nums[bit];
                }
            }
            res += tempXr;
        }
        
        return res;
    }
};