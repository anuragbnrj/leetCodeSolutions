class Solution {
public:
    int minDifference(vector<int>& nums) {
        int n = nums.size();

        if (n <= 4) {
            return 0;
        }

        sort(nums.begin(), nums.end());

        if (n == 5) {
            int ans = 2e9 + 1;
            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 5; j++) {
                    ans = min(ans, nums[j] - nums[i]);
                }
            }

            return ans;
        }

        int ans = min(nums[n - 2] - nums[2], nums[n - 3] - nums[1]);
        return ans;
        
    }
};