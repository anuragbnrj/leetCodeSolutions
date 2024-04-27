class Solution {
public:
    int findRotateSteps(string ring, string key) {
        int szRing = ring.size();
        int szKey = key.size();

        vector<vector<int>> dp(szRing + 1, vector<int>(szKey + 1, -1));
        int res = solve(ring, key, 0, 0, dp);

        res += (int) key.size();
        return res;
    }

private:
    int solve(string ring, string key, int idxRing, int idxKey, vector<vector<int>> &dp) {
        if (dp[idxRing][idxKey] != -1) {
            return dp[idxRing][idxKey];
        }
        
        int szRing = ring.size();
        int szKey = key.size();

        if (idxKey >= szKey) {
            return 0;
        }

        if (idxRing >= szRing) {
            return 0;
        }

        int res = INT_MAX;
        for (int i = 0; i < szRing; i++) {
            int newIdx = (idxRing + i) % szRing;
            if (ring[newIdx] == key[idxKey]) {
                res = min(res, i + solve(ring, key, newIdx, idxKey + 1, dp));
            }
        }

        for (int i = 0; i < szRing; i++) {
            int newIdx = (((idxRing - i) % szRing) + szRing) % szRing;
            if (ring[newIdx] == key[idxKey]) {
                res = min(res, i + solve(ring, key, newIdx, idxKey + 1, dp));
            }
        }

        return dp[idxRing][idxKey] = res;
    }
};