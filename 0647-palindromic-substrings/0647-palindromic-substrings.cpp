class Solution {
public:
    int countSubstrings(string s) {
        int len = s.size();
        
        vector<vector<int>> dp(len, vector<int>(len, -1));
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(i, j, s, dp) == 1) {
                    res++;
                }
            }
        }
        
        return res;
    }

private:
    int isPalindrome(int beg, int end, string s, vector<vector<int>> &dp) {
        if (dp[beg][end] != -1) {
            return dp[beg][end];
        }

        if (beg > end) {
            return 0;
        }

        if (beg == end) {
            return dp[beg][end] = 1;
        }

        if ((end - beg) == 1) {
            if (s[beg] == s[end]) {
                return dp[beg][end] = 1;
            }
        }

        int res = 0;
        if (isPalindrome(beg + 1, end - 1, s, dp) == 1 && s[beg] == s[end]) {
            res = 1;
        }

        return dp[beg][end] = res;
    }
};