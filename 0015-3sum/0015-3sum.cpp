class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int len = nums.size();
        vector<vector<int>> res;

        sort(nums.begin(), nums.end());

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];

            int l = i + 1;
            int r = len - 1;

            while (l < r) {
                int b = nums[l];
                int c = nums[r];
                if (a + b + c < 0) {
                    l++;
                } else if (a + b + c > 0) {
                    r--;
                } else {
                    res.push_back({nums[i], nums[l], nums[r]});
                    l++;
                    r--;

                    while (0 < l && l < len && (nums[l] == nums[l - 1])) {
                        l++;
                    }

                    while (0 <= r && r < len - 1 && (nums[r] == nums[r + 1])) {
                        r--;
                    }
                }
            }
        }

        return res;
    }
};