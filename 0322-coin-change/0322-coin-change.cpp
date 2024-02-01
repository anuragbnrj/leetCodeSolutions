class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<vector<int>> dp(coins.size() + 1, vector<int> (amount + 1, -2));
        return solve(0, amount, coins, dp);
    }

private:
    int solve(int idx, int amount, vector<int> &coins, vector<vector<int>> &dp) {
        if (dp[idx][amount] != -2) {
            return dp[idx][amount];
        }

        if (amount == 0) {
            return 0;
        }

        if (idx == coins.size()) {
            return -1;
        }

        int pick = INT_MAX;
        int notPick = INT_MAX;
        int temp = 0;
        if (amount - coins[idx] >= 0) {
            temp = solve(idx, amount - coins[idx], coins, dp);
            if (temp != -1) {
                pick = 1 + temp;
            } 
        }

        temp = solve(idx + 1, amount, coins, dp);
        if (temp != -1) {
            notPick = temp;
        }

        if (pick == INT_MAX && notPick == INT_MAX) {
            return dp[idx][amount] = -1;
        }
        
        return dp[idx][amount] = min(pick, notPick);
    }
};