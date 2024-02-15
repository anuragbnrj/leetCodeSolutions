class Solution {
public:
    long long largestPerimeter(vector<int>& nums) {
        int len = nums.size();
        sort(nums.begin(), nums.end());

        vector<long long> csum(len);
        csum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            csum[i] = csum[i - 1] + nums[i];
        }

        long long maxPeri = -1;
        for (int i = len - 1; i >= 2; i--) {
            if (nums[i] < csum[i - 1]) {
                maxPeri = csum[i - 1] + nums[i];
                break;
            }
        }

        return maxPeri; 
    }
};