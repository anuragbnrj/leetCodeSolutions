class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        int n = nums.size();

        vector<int> locationCount(k, 0);
        locationCount[0] = 1;
        int currSum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            int rem = currSum % k;

            if (locationCount[rem] != 0) {
                res += locationCount[rem];
            }

            locationCount[rem] += 1;
        }

        return res;
    }
};