class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        // int len = arr.size();
        // vector<int> dp(len + 1, -1);
        // return solve(0, k, arr, dp);

        int len = arr.size();
        vector<int> dp(len + 1, 0);

        for (int idx = len - 1; idx >= 0; idx--) {
            int maxi = INT_MIN;
            int res_right = 0;
            int sum = 0;
            int res = 0;
            for (int i = idx; i < idx + k && i < len; i++) {
                maxi = max(maxi, arr[i]);
                res_right = dp[i + 1];
                res = max(res, maxi * (i - idx + 1) + res_right);
            }

            dp[idx] = res;
        }

        return dp[0];
    }

    // int solve(int idx, int k, vector<int>& arr, vector<int>& dp) {
    //     if (idx >= arr.size()) {
    //         return 0;
    //     }

    //     if (dp[idx] != -1) {
    //         return dp[idx];
    //     }

    //     int len = arr.size();

    //     int maxi = INT_MIN;
    //     int res_right = 0;
    //     int sum = 0;
    //     int res = 0;
    //     for (int i = idx; i < idx + k && i < len; i++) {
    //         maxi = max(maxi, arr[i]);
    //         res_right = solve(i + 1, k, arr, dp);
    //         res = max(res, maxi * (i - idx + 1) + res_right);
    //     }

    //     return dp[idx] = res;
    // }
};