class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> res;

        vector<string> curr;
        solve(0, s, curr, res);

        return res;
    }

private:
    void solve(int beg, string s, vector<string> &curr, vector<vector<string>> &res) {
        if (beg == (int)s.size()) {
            if (curr.size() > 0) {
                res.push_back(curr);
            }
            return;
        }

        int n = s.size();

        string temp = "";
        for (int i = beg; i < n; i++) {
            temp += s[i];

            if (isPalindrone(temp)) {
                curr.push_back(temp);
                solve(i + 1, s, curr, res);
                curr.pop_back();
            }
        }

        return;
    }

    bool isPalindrone(string s) {
        int n = s.size();

        for (int beg = 0, end = n - 1; beg <= end; beg++, end--) {
            if (s[beg] != s[end]) {
                return false;
            }
        }

        return true;
    }
};