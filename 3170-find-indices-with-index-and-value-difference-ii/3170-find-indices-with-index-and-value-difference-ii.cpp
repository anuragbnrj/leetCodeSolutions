class Solution {
public:
    vector<int> findIndices(vector<int>& nums, int indexDifference, int valueDifference) {
        int len = nums.size();
        int mn = INT_MAX;
        int mnIdx = -1;
        int mx = INT_MIN;
        int mxIdx = -1;

        int k = 0;
        for (int i = indexDifference; i < len; i++) {
            if (nums[k] < mn) {
                mn = nums[k];
                mnIdx = k;
            }

            if (nums[k] > mx) {
                mx = nums[k];
                mxIdx = k;
            }
            k++;

            
            if (abs(nums[i] - mn) >= valueDifference) {
                return {i, mnIdx};
            } else if (abs(nums[i] - mx) >= valueDifference) {
                return {i, mxIdx};
            }

        }

        return {-1, -1};
        
    }
};