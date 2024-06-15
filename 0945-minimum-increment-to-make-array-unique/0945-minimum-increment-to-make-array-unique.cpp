class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        int n = nums.size();

        vector<int> freq(200005, 0);
        int mn = 1e9;
        for (int num : nums) {
            freq[num] += 1;
            mn = min(mn, num);
        }

        int ans = 0;
        for (int i = mn; i < 200004; i++) {
            if (freq[i] <= 1) continue;

            int actual = freq[i];
            int incorrect = actual - 1;
            ans += incorrect;
            freq[i + 1] += incorrect;
        }

        return ans;
    }
};