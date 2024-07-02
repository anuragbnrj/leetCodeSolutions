class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> freq1(1001);
        for (int num : nums1) {
            freq1[num] += 1;
        }

        vector<int> freq2(1001);
        for (int num : nums2) {
            freq2[num] += 1;
        }

        vector<int> ans;
        for (int i = 0; i <= 1000; i++) {
            if (freq1[i] > 0 && freq2[i] > 0) {
                for (int j = 0; j < min(freq1[i], freq2[i]); j++) {
                    ans.push_back(i);
                }
            }
        }

        return ans;
    }
};