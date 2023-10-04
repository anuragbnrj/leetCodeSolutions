class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int len = nums.size();

        int idx = -1;
        for (int i = len - 2; i >= 0; i--) {
            int curr = nums[i];
            int next = nums[i + 1];

            if (curr < next) {
                idx = i;
                break;
            } 
        }

        if (idx == -1) {
            reverse(nums.begin(), nums.end());
            return;
        }

        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums[i], nums[idx]);
                break;
            }
        }

        reverse(nums.begin() + idx + 1, nums.end());
    }
};
