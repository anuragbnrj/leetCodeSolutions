class Solution {
public:
    int maximumLength(vector<int>& nums, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = max(ans, getMaxLen(nums, k, i));
        }
        
        return ans;
    }

private:
    int getMaxLen(vector<int> &nums, int k, int rem) {
        int ans = 0;
        vector<int> mpp(k + 1, 0);
        for (int i = 0; i < nums.size(); i++) {
            int currRem = nums[i] % k;
            int reqdRem = ((rem - currRem) % k + k) % k;
            
            int currLen = mpp[reqdRem] + 1;
            
            ans = max(ans, currLen);
            
            mpp[currRem] = currLen;
        }
        
        return ans;
    }
};