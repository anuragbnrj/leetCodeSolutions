class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int len = nums.size();
        vector<int> rmax(len, 0);
        int min = INT_MAX, min2 = INT_MAX;

        for (int i = 0; i < len; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= min2) {
                min2 = nums[i];
            } else {
                return true;
            }
        }

        return false;        
    }
};