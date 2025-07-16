class Solution {
public:
    int maximumLength(vector<int>& nums) {
        int n = nums.size();
        
        int prev = 0;
        int ans = 0;
        int currLen = 0;
        for (int i = 0; i < n; i++) {
            if ((prev + nums[i]) % 2 == 0) {
                currLen++;
                prev = nums[i];
            }
        }
        ans = max(ans, currLen);
        
        prev = 0;
        currLen = 0;
        for (int i = 0; i < n; i++) {
            if ((prev + nums[i]) % 2 == 1) {
                currLen++;
                prev = nums[i];
            }
        }
        ans = max(ans, currLen);
        
        prev = 1;
        currLen = 0;
        for (int i = 0; i < n; i++) {
            if ((prev + nums[i]) % 2 == 0) {
                currLen++;
                prev = nums[i];
            }
        }
        ans = max(ans, currLen);
        
        prev = 1;
        currLen = 0;
        for (int i = 0; i < n; i++) {
            if ((prev + nums[i]) % 2 == 1) {
                currLen++;
                prev = nums[i];
            }
        }
        ans = max(ans, currLen);
        
        return ans;
        
    }
};