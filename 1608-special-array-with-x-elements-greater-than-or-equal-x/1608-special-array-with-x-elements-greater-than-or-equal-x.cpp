class Solution {
public:
    int specialArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> freq(1002, 0);
        for (int num : nums) {
            freq[num]++;
        }

        vector<int> csum(1002, 0);
        for (int i = 1000; i >= 0; i--) {
            csum[i] = freq[i] + csum[i + 1];

            if (csum[i] == i) {
                return i;
            } 
        }

        return -1;
    }
};