class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int n = nums.size();

        int xr = 0;
        for (int i = 0; i < n; i++) {
            xr = xr ^ nums[i];
        }

        int a = xr;
        int b = k;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int lastA = a & 1;
            int lastB = b & 1;

            if (lastA != lastB) {
                res++;
            }

            a = a >> 1;
            b = b >> 1;
        }
        
        return res;
    }
};