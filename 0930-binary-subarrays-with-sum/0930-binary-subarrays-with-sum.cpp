class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        unordered_map<int, int> prevSum;
        prevSum[0] = 1;

        int currSum = 0;
        int res = 0;
        for (int num : nums) {
            currSum += num;

            if (currSum >= goal) {
                if (prevSum.count(currSum - goal)) {
                    res += prevSum[currSum - goal];
                }
            }

            prevSum[currSum]++;
        }

        return res;
    }
};