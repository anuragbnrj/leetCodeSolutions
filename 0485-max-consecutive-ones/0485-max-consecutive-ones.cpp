class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int len = nums.size();
        int mx = INT_MIN;
        int curr = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                curr++;
                mx = max(mx, curr);
            } else {
                curr = 0;
            }
        }

        return mx == INT_MIN ? 0 : mx;
    }
};