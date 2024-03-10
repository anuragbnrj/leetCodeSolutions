class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> stt1(nums1.begin(), nums1.end());

        unordered_set<int> intersection;
        for (int num : nums2) {
            
            if (stt1.count(num)) {
                intersection.insert(num);
            }
        }

        vector<int> res(intersection.begin(), intersection.end());

        return res;
    }
};