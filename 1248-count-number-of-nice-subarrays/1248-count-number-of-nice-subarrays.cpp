class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }

private:
    int solve(vector<int> &nums, int k) {
        int n = nums.size();

        int res = 0;
        int oddCount = 0;
        for (int beg = 0, end = 0; end < n; end++) {
            if (nums[end] % 2 == 1) {
                oddCount++;
            }

            while (oddCount > k) {
                if (nums[beg] % 2 == 1) {
                    oddCount--;
                }

                beg++;
            }

            res += end - beg + 1;
        }

        return res;
    }
};
