class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> stt1, stt2;

        for (int el : nums1) {
            stt1.insert(el);
        }

        for (int el : nums2) {
            stt2.insert(el);
        }

        vector<vector<int>> res(2, vector<int>(0));
        for (int el : stt1) {
            if (stt2.count(el) == 0) {
                res[0].push_back(el);
            }
        }

        for (int el : stt2) {
            if (stt1.count(el) == 0) {
                res[1].push_back(el);
            }
        }

        return res;
    }
};