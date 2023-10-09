class Solution {
public:
    bool check(vector<int>& nums) {
        int len = nums.size();
        int dec = 0;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            int next = nums[(i + 1) % len];

            if (next < curr) {
                dec++;
            }
        }

        if (dec <= 1) {
            return true;
        } else {
            return false;
        }
        
    }
};