class Solution {
public:
    long long mod = 1e9 + 7;
    int x = 100005, y = 3, z = 4;
    long long dp[100005][3][4];

    int checkRecord(int n) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(n, 1, 0, 0);
    }

private:
    long long solve(int totalDays, int day, int absent, int consecutiveLate) {
        if (day > totalDays) {
            return 1;
        }

        if (dp[day][absent][consecutiveLate] != -1) {
            return dp[day][absent][consecutiveLate];
        }

        long long tot = 0;

        // Present
        tot =  (tot + solve(totalDays, day + 1, absent, 0)) % mod;

        // Absent
        if (absent == 0) {
            tot =  (tot + solve(totalDays, day + 1, absent + 1, 0)) % mod;
        }

        if (consecutiveLate < 2) {
            tot = (tot + solve(totalDays, day + 1, absent, consecutiveLate + 1)) % mod;
        }

        return dp[day][absent][consecutiveLate] = tot;
    }
};