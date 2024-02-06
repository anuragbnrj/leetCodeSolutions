class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int len = strs.size();

        unordered_map<string, vector<string>> groups;
        for (int i = 0; i < len; i++) {
            string temp = strs[i];
            sort(temp.begin(), temp.end());

            groups[temp].push_back(strs[i]);
        }

        vector<vector<string>> res;
        for (auto el : groups) {
            res.push_back(el.second);
        }

        return res;
    }
};