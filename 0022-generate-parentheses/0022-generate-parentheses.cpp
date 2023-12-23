class Solution {
public:
    vector<string> generateParenthesis(int n) {
        string ds = "";
        vector<string> res;
        solve(0, n, ds, res);

        return res;
    }

private:
    void solve(int idx, int n, string ds, vector<string> &res) {
        if (idx == (2 * n)) {
            if (isWellFormed(n, ds)) {
                res.push_back(ds);
            }
            return;
        }
        
        ds += '(';
        solve(idx + 1, n, ds, res);
        ds.pop_back();

        ds += ')';
        solve(idx + 1, n, ds, res);
        ds.pop_back();
    }

    bool isWellFormed(int n, string &ds) {
        int ctr = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds[i] == '(') {
                ctr++;
            } else {
                ctr--;
            }

            if (ctr < 0 || ctr > n) {
                return false;
            }
        }

        if (ctr == 0) {
            return true;
        }

        return false;
    }
};