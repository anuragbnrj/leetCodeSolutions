class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int len = nums.size();

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        
        map<int, int> prev;
        map<int, bool> hasOccurred;
        prev[0] = -1;
        hasOccurred[0] = true;
        int currSum = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            currSum += nums[i];

            if (hasOccurred[currSum]) {
                int currLen = i - prev[currSum];
                res = max(res, currLen);
            } else {
                hasOccurred[currSum] = true;
                prev[currSum] = i;
            }
        }

        return res;
    }
};