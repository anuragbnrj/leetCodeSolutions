class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<char> ds;
        vector<string> res;
        solve(0, 0, n, ds, res);

        return res;
    }

private:
    void solve(int idx, int ctr, int n, vector<char> ds, vector<string> &res) {
        if (idx == (2 * n)) {
            if (isWellFormed(n, ds)) {
                res.push_back(accumulate(ds.begin(), ds.end(), string()));
            }

            // res.push_back(accumulate(ds.begin(), ds.end(), string()));
            return;
        }

        if (ctr < n) {
            ds.push_back('(');
            solve(idx + 1, ctr + 1, n, ds, res);
            ds.pop_back();
        }
        
        if (ctr > 0) {
            ds.push_back(')');
            solve(idx + 1, ctr - 1, n, ds, res);
            ds.pop_back();
        }
    }

    bool isWellFormed(int n, vector<char> &ds) {
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