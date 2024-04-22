class Solution {
public:
    int res = INT_MAX;
    int openLock(vector<string>& deadends, string target) {
        set<string> dead(deadends.begin(), deadends.end());

        string curr = "0000";

        solve(dead, target, curr, 0, 0);

        return (res == INT_MAX ? -1 : res);
    }

private:
    void solve(set<string> &dead, string target, string curr, int idx, int moves) {
        if (dead.find(curr) != dead.end()) {
            return;
        }

        if (curr == target) {
            res = min(res, moves);
            return;
        }

        if (idx >= 4) {
            return;
        }

        int digit = curr[idx] - '0';

        solve(dead, target, curr, idx + 1, moves);
        
        possible = true;
        for (int i = 1; i < 10 && possible; i++) {
            int next = (digit + i) % 10;
            curr[idx] = next + '0';
            
            solve(dead, target, curr, idx + 1, moves + i);
        }

        possible = true;
        for (int i = 1; i < 10 && possible; i++) {
            int prev = (((digit - i) % 10) + 10) % 10;
            curr[idx] = prev + '0';
            
            solve(dead, target, curr, idx + 1, moves + i);
        }

    }
};