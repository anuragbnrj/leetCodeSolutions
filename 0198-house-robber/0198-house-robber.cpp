class Solution {
public:
    int rob(vector<int>& nums) {
        // vector<int> dp(nums.size(), -1);
        // return maxAmount(0, -1, nums, dp);

        int len = nums.size();
        vector<int> dp(len + 2, 0); 

        for (int idx = len - 1; idx >= 0; idx--) {
            int pick = nums[idx] + dp[idx + 2];
            int not_pick = dp[idx + 1];

            dp[idx] = max(pick, not_pick);
        }

        return dp[0];
    }

    // int maxAmount(int idx, int prev_idx, vector<int>& nums, vector<int>& dp) {
    //     if (idx >= nums.size()) {
    //         return 0;
    //     }

    //     if (dp[idx] != -1) {
    //         return dp[idx];
    //     }

    //     int pick = nums[idx] + maxAmount(idx + 2, idx, nums, dp);
    //     int not_pick = maxAmount(idx + 1, prev_idx, nums, dp);


    //     return dp[idx] = max(pick, not_pick);
    // }
};