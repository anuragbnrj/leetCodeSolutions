class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int N = nums.size();

        vector<vector<int>> res;
        for (int mask = 0; mask < (1 << N); mask++) {
            vector<int> subset;
            for (int bit = 0; bit < N; bit++) {
                if (((mask >> bit) & 1) == 1) {
                    subset.push_back(nums[bit]);
                }
            }

            res.push_back(subset);
        }

        return res;
    }
};