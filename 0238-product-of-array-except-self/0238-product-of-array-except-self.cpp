class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int len = nums.size();
        vector<int> rpr(len);

        int currPr = 1;
        for (int i = len - 1; i >= 0; i--) {
            currPr *= nums[i];

            rpr[i] = currPr;
        }

        currPr = 1;
        vector<int> res(len);
        for (int i = 0; i < len - 1; i++) {
            res[i] = currPr * rpr[i + 1];

            currPr *= nums[i];
        }
        res[len - 1] = currPr;

        return res;
        
    }
};