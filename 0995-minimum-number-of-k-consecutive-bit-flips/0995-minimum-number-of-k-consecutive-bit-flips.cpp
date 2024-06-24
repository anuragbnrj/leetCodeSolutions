class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> psum(n + 2, 0);

        int currFlips = 0;
        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            psum[i] += psum[i - 1];

            // cout << "i: " << i << ", curr: " << curr << ", psum[i]: " << psum[i]
            //      << ", currFlips: " << currFlips << endl;

            if (curr + psum[i] + currFlips % 2 == 0) {
                // cout << "Hello" << endl;
                if (i + k - 1> n) {
                    return -1;
                }

                currFlips += 1;
                psum[i + k] += -1;
            }
        }

        return currFlips;
    }
};