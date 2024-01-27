class Solution {
public:
    int kInversePairs(int n, int k) {
        vector<vector<int>> dp(1001,vector<int>(1001,-1));
        return solve(n,k,dp);
    }
private:
    int M=1e9+7;
    int solve(int n, int k,vector<vector<int>>& dp){
        if(n==0)return 0;
        if(k==0)return 1;
        if(dp[n][k]!=-1)return dp[n][k];
        int cnt=0;
        for(int i=0; i<=min(k,n-1);i++){
            cnt=(cnt+solve(n-1,k-i,dp))%M;
        }
        return dp[n][k]=cnt%M;
    }
};