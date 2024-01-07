class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int len = nums.size();
        int res = 0;
        vector<unordered_map<long long, int>> dp(len);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                long long diff = nums[i] - nums[j] * 1LL;
                dp[i][diff] += 1;
                if(dp[j].count(diff)) {
                    dp[i][diff] += dp[j][diff];
                    res = res + dp[j][diff];
                }
            }
        }

        return res;
    }

// private:
//     int solve(int idx, vector<int>& nums, int subSz, long long diff, int prev) {
//         // base case
//         if (idx == nums.size()) {
//             if(subSz >= 3) {
//                 return 1;
//             } else {
//                 return 0;
//             }
//         }

//         int pick = 0;
//         if (subSz == 0) {
//             // subsequence.push_back(nums[idx]);
//             subSz += 1;
//             pick = solve(idx + 1, nums, subSz, diff, nums[idx]);
//             subSz -= 1;
//             // subsequence.pop_back();
//         }

//         if (subSz == 1) {
//             // subsequence.push_back(nums[idx]);
//             subSz += 1;
//             pick = solve(idx + 1, nums, subSz, nums[idx] - prev * 1LL, nums[idx]);
//             subSz -= 1;
//             // subsequence.pop_back();
//         }

//         if (subSz >= 2) {
//             long long currDiff = nums[idx] - prev * 1LL;
//             if (diff == currDiff) {
//                 // subsequence.push_back(nums[idx]);
//                 subSz += 1;
//                 pick = solve(idx + 1, nums, subSz, currDiff, nums[idx]);
//                 subSz -= 1;
//                 // subsequence.pop_back();
//             }
//         }


//         int notPick = solve(idx + 1, nums, subSz, diff, prev);

//         return pick + notPick;
//     }
};