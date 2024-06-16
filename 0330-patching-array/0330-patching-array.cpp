class Solution {
public:
    int minPatches(vector<int>& nums, int range) {
        int n = nums.size();

        long long maxReachable = 0;
        int i = 0;
        int patches = 0;
        while (maxReachable < range) {
            if (i < n && nums[i] - 1 <= maxReachable) {
                maxReachable += nums[i];
                i++;
            } else {
                patches += 1;
                maxReachable += (maxReachable + 1);
            }
        }

        return patches;
    }
};