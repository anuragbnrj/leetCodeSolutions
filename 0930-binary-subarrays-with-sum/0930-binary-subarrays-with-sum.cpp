class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        return solve(nums, goal) - solve(nums, goal - 1);
    }

private:
    int solve(vector<int> &nums, int goal) {
        int n = nums.size();
        
        int res = 0;
        int currSum = 0;
        for (int beg = 0, end = 0; end < n; end++) {
            currSum += nums[end];

            while (beg <= end && currSum > goal) {
                currSum -= nums[beg];

                beg++;
            }

            res += (end - beg + 1);
        }

        return res;
    }
};