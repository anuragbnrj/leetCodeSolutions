class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int len = nums.size();
        map<int, int> freq;

        for (int i = 0; i < len; i++) {
            freq[nums[i]]++;
        }

        for (auto el : freq) {
            int f = el.second;

            if (f > (len / 2)) {
                return el.first;
            }
        }

        return 0;
    }
};