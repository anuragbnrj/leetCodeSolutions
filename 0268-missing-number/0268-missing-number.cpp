class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int requiredSum = (n * (n + 1)) / 2;
         
        return requiredSum - accumulate(nums.begin(), nums.end(), 0);
    }
};