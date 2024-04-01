class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size();

        multiset<int> mset;
        vector<int> res;
        for (int beg = 0, end = 0; end < n; end++) {
            mset.insert(nums[end]);

            while (end - beg + 1 > k) {
                int del = nums[beg];
                beg++;

                mset.erase(mset.find(del));
            }

            if (end - beg + 1 == k) {
                res.push_back(*mset.rbegin());
            }
        }

        return res;
    }
};