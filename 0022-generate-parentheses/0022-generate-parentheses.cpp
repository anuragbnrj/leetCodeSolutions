class Solution {
public:
    vector<string> generateParenthesis(int n) {
        string curr = "";
        vector<string> res;
        solve(n, n, curr, res);

        return res;
    }

private:
    void solve(int l, int r, string curr, vector<string> &res) {
        if (l == 0 && r == 0) {
            res.push_back(curr);
            return;
        }
        
        if (l > 0) {
            curr += '(';
            solve(l - 1, r, curr, res);
            curr.pop_back();
        }
        

        if (r > l) {
            curr += ')';
            solve(l, r - 1, curr, res);
            curr.pop_back();
        }
    }
};