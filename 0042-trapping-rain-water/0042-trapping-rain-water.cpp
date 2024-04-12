class Solution {
public:
    int trap(vector<int>& height) {
        int len = height.size();
        int lef[len]; 
        int rig[len]; 

        int lmax = height[0];
        int rmax = height[len - 1];
        for (int i = 0; i < len; i++) {
            lef[i] = lmax;
            if (height[i] > lmax) {
                lmax = height[i];
            }

            rig[len - 1 - i] = rmax;
            if(height[len - 1 - i] > rmax) {
                rmax = height[len - 1 - i];
            }
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            if (lef[i] > height[i] && rig[i] > height[i]) {
                res = res + min((lef[i] - height[i]), (rig[i] - height[i]));
            }
        }

        return res;
    }
};