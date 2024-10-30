class Solution {
public:
    int minimumMountainRemovals(vector<int>& nums) {
        int len = nums.size();
        vector<int> mtn_arr;
        vector<int> LIS(len, 1);
        vector<int> LDS(len, 1);
        int res = INT_MIN;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && (LIS[j] + 1 > LIS[i])) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }


        for(int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j] && (LDS[j] + 1 > LDS[i])) {
                    LDS[i] = LDS[j] + 1;
                }
            }
        }

        for (int i = 1; i < len - 1; i++) {
            if (LIS[i] > 1 && LDS[i] > 1) {
                res = max(res, LIS[i] + LDS[i] - 1);
            }
        }


        return nums.size() - res;
    }

    // int f(int idx, vector<int>& nums, vector<int>& mtn_arr, vector<int>& dp) {
    //     if (idx >= nums.size()) {
    //         int n = mtn_arr.size();
    //         if (n < 3) {
    //             return INT_MAX;  // Array should have at least 3 elements
    //         }

    //         int i = 0;
    //         while (i < n - 1 && mtn_arr[i] < mtn_arr[i + 1]) {
    //             i++;
    //         }

    //         if (i == 0 || i == n - 1) {
    //             return INT_MAX;  // No peak element or peak at the first or last position
    //         }

    //         while (i < n - 1 && mtn_arr[i] > mtn_arr[i + 1]) {
    //             i++;
    //         }

    //         if (i == n - 1) {
    //             return nums.size() - mtn_arr.size();
    //         } else {
    //             return INT_MAX;
    //         }
    //     }

    //     if (dp[idx] != -1) {
    //         return dp[idx];
    //     }

    //     mtn_arr.push_back(nums[idx]);
    //     int pick = f(idx + 1, nums, mtn_arr, dp);
    //     mtn_arr.pop_back();
    //     int not_pick = f(idx + 1, nums, mtn_arr, dp);

    //     return dp[idx] = min(not_pick, pick);
    // }
};