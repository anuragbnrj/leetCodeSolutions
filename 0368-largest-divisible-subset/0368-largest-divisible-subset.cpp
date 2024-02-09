class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int len = nums.size();
        sort(nums.begin(), nums.end());

        vector<int> res;
        int mxSize = 0;
        vector<vector<int>> dp(len, vector<int>(0));
        for (int i = 0; i < len; i++) {
            vector<int> temp = solve(i, nums, dp);
            int currSize = temp.size();
            if (currSize > mxSize) {
                mxSize = currSize;
                res = temp;
            }
        }

        return res;        
    }

private:
    vector<int> solve(int n, vector<int> &nums, vector<vector<int>> &dp) {
        if (n < 0) {
            return {};
        }

        if (dp[n].size() != 0) {
            return dp[n];
        }

        vector<int> res = {nums[n]};
        int mxSize = 1;
        for (int i = 0; i < n; i++) {
            if (nums[n] % nums[i] == 0) {
                vector<int> temp = solve(i, nums, dp);
                temp.push_back(nums[n]);

                int currSize = temp.size();
                if (currSize > mxSize) {
                    mxSize = currSize;
                    res = temp;
                }
            }
        }

        return dp[n] = res;
    }
};