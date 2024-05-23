class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        int n = nums.size();

        vector<pair<int, int>> conflicts;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (abs(nums[i] - nums[j]) == k) {
                    conflicts.push_back({i, j});
                }
            }
        }

        int res = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            vector<int> subset;
            set<int> indices;
            for (int bit = 0; bit < n; bit++) {
                if (mask >> bit & 1) {
                    subset.push_back(nums[bit]);
                    indices.insert(bit);
                }
            }

            bool flag = true;
            for (auto conflict : conflicts) {
                int i = conflict.first;
                int j = conflict.second;

                if (indices.find(i) != indices.end() && indices.find(j) != indices.end()) {
                    flag = false;
                    break;
                }
            }

            if (flag == true) res++;
        }

        return res - 1;
        
    }
};