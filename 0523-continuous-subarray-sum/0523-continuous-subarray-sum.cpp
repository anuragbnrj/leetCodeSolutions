class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        int n = nums.size();

        map<int, int> location;
        location[0] = -1;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            int rem = currSum % k;

            if (location.contains(rem)) {
                if (i - location[rem] >= 2) {
                    return true;
                }
            } else {
                location[rem] = i;
            }
        }

        return false;
    }
};