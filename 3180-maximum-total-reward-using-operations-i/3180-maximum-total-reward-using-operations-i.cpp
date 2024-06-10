class Solution {
public:
    int maxTotalReward(vector<int>& rewardValues) {
        int n = rewardValues.size();
        sort(rewardValues.begin(), rewardValues.end());
        
        vector<vector<int>> dp(n + 5, vector<int>(4005, -1));
        
        return solve(0, 0, rewardValues, dp);
    }
    
private:
    int solve(int idx, int prevSum, vector<int> &val, vector<vector<int>> &dp) {
        int n = val.size();
        if (idx == n) {
            return dp[idx][prevSum] = prevSum;
        }
        
        if (prevSum >= 2*(val[n - 1])) {
            return dp[idx][prevSum] = prevSum;
        }
        
        if (dp[idx][prevSum] != -1) {
            return dp[idx][prevSum];
        }
        
        int choose = 0, notChoose = 0;
        
        // not choose
        notChoose = solve(idx + 1, prevSum, val, dp);
        
        // choose
        if (prevSum < val[idx]) {
            choose = solve(idx + 1, prevSum + val[idx], val, dp);
        }
        
        return dp[idx][prevSum] = max(choose, notChoose);
    }
};