class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        int len = nums.size();

        map<int, int> freq;
        int currOdd = 0;
        freq[0] = 1;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 1) {
                currOdd++;
            }

            int req = currOdd - k;
            res += freq[req];
            freq[currOdd]++;
        }

        return res;
    }
};