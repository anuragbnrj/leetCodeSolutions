class Solution {
public:
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        int len = nums.size();
        sort(nums.begin(), nums.end());

        vector<vector<int>> res;
        bool possible = true;
        for (int i = 0; i < len - 2; ) {
            if ((nums[i + 2] - nums[i]) <= k) {
                res.push_back({nums[i], nums[i + 1], nums[i + 2]});
                i += 3;
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            return res;
        } else {
            return {};
        }
    }
};