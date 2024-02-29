class Solution {
public:
    int findPeakElement(vector<int>& arr) {
        vector<long long> nums(arr.begin(), arr.end());
        nums.insert(nums.begin(), INT_MIN - 1LL);
        nums.push_back(INT_MIN - 1LL);

        int beg = 1;
        int end = nums.size();

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid - 1;
            } else if (nums[mid - 1] <= nums[mid] && nums[mid] <= nums[mid + 1]) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }

        return -1;
    }
};