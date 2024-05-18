class Solution {
public:
    int singleNumber(vector<int>& nums) {
        vector<int> freq(32, 0);

        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];

            for (int bit = 0; bit < 32; bit++) {
                if ((num >> bit) & 1) {
                    freq[bit]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            // cout << freq[i] << "\t";

            if ((freq[i] % 3) != 0) {
                res = res + 1 * (1 << i);
            }
        }
        // cout << endl;
        
        return res;
    }
};