class Solution {
private:
    void solve(int idx, vector<int> &candidates, int target, vector<int> &curr, vector<vector<int>> &res) {
        // cout << "idx: " << idx << "\t target: " << target << endl;
        if (target == 0) {
            res.push_back(curr);
            return;
        }

        if (idx == candidates.size()) {
            return;
        }

        for (int i = idx; i < candidates.size(); ) {
            if (candidates[i] <= target) {
                curr.push_back(candidates[i]);
                solve(i + 1, candidates, target - candidates[i], curr, res);
                curr.pop_back();
                i++;

                while (i < candidates.size() && candidates[i] == candidates[i - 1]) {
                    i++;
                }
            } else {
                break;
            }
        }
    }

public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        int len = candidates.size();
        sort(candidates.begin(), candidates.end());

        vector<vector<int>> res;
        vector<int> curr;
        solve(0, candidates, target, curr, res);

        return res;
    }
};