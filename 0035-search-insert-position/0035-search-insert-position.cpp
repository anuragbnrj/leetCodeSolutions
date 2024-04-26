class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int n = nums.size();
        int beg = 0;
        int end = n;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;
            if (nums[mid] < target) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }
};