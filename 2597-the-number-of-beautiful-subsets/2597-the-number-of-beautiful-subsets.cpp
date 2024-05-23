class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        int n = nums.size();

        int res = 0;
        vector<int> freq(1001, 0);
        for (int mask = 0; mask < (1 << n); mask++) {
            int flag = true;

            for (int bit = 0; bit < n; bit++) {
                if (mask >> bit & 1) {
                    if ((nums[bit] + k <= 1000 && freq[nums[bit] + k] > 0) ||
                        (nums[bit] - k >= 0 && freq[nums[bit] - k] > 0)) {
                        flag = false;
                    }

                    freq[nums[bit]]++;
                }
            }

            if (flag == true)
                res++;

            for (int bit = 0; bit < n; bit++) {
                if (mask >> bit & 1) {
                    freq[nums[bit]]--;
                }
            }
        }

        return res - 1;
    }
};