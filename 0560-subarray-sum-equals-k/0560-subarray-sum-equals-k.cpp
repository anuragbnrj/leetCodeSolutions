class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int len = nums.size();
        unordered_map<int, int> freq;
        int csum = 0, res = 0;

        for (int i = 0; i < len; i++) {
            csum += nums[i];

            if (csum == k) {
                res++;
            }

            res += freq[csum - k];
            freq[csum]++;
        }
        
        return res;
    }
};