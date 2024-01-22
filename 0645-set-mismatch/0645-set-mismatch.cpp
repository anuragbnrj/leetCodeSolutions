class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int len = nums.size();
        vector<int> freq(len + 1, 0);
        int repeat, missing;
        long long act = 0, exp = 0;

        for (int i = 0; i < len; i++) {
            if (freq[nums[i]] > 0) {
                repeat = nums[i];
            }
            freq[nums[i]]++;
            act += nums[i];
            exp += (i + 1);
        }

        missing = exp - (act - repeat);
        return {repeat, missing};
    }
};