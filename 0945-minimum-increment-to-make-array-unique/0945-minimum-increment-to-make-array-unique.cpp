class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        int n = nums.size();

        set<int> isUsed;
        sort(nums.begin(), nums.end());

        int ans = 0;
        for (int i = 0, j = nums[0]; i < n; ) {
            if (isUsed.find(j) != isUsed.end()) {
                j++;
                ans++;
            } else {
                i++;
                isUsed.insert(j);
                if (i < n) j = nums[i];
            }
        }

        return ans;
    }
};