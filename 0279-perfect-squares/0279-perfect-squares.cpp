class Solution {
public:
    int numSquares(int n) {
        set<int> perfectSquares;
        for (int i = 1; i * i <= n; i++) {
            perfectSquares.insert(i * i);
        }

        // vector<int> dp(n + 1, -1);
        // int res = solve(n, perfectSquares, dp); 
        // return res;

        vector<int> dp(n + 1, 0);

        for (int i = 1; i <= n; i++) {
            if (perfectSquares.count(i)) {
                dp[i] = 1;
            } else {
                int res = INT_MAX;
                for (auto el : perfectSquares) {
                    int diff = i - el;

                    if (diff < 0) {
                        break;
                    }

                    int temp = dp[diff];

                    if (temp != INT_MAX) {
                        res = min(res, 1 + temp);
                    }
                }
                dp[i] = res; 
            }
        }

        return dp[n];
    }

// private:
//     int solve(int n, set<int> &perfectSquares, vector<int> &dp) {
//         if (dp[n] != -1) {
//             return dp[n];
//         }

//         if (n == 0) {
//             return dp[n] = 0;
//         }

//         if (perfectSquares.count(n)) {
//             return dp[n] = 1;
//         }

//         int res = INT_MAX;
//         for (auto el : perfectSquares) {
//             int diff = n - el;

//             if (diff < 0) {
//                 break;
//             }

//             int temp = solve(diff, perfectSquares, dp);

//             if (temp != INT_MAX) {
//                 res = min(res, 1 + temp);
//             }
            
//         }

//         return dp[n] = res;
//     }
};