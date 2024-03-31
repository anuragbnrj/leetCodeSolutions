class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        int n = nums.size();

        int boundary = 1e9 + 7;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || maxK < nums[i]) {
                nums[i] = boundary;
            }
        }

        int l = 0;
        bool started = false;
        long long res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == boundary) {
                if (started) {
                    res += solve(l, i - 1, nums, minK, maxK);
                    started = false;
                }
            } else {
                if (!started) {
                    l = i;
                    started = true;
                }
            }
        }

        if (started) {
            res += solve(l, n - 1, nums, minK, maxK);
        }

        return res;
    }

private:
    long long solve(int l, int r, vector<int> &nums, int minK, int maxK) {
        vector<int> lastOccurred(2, -1);
        long long res = 0;
        for (int end = l; end <= r; end++) {
            if (nums[end] == minK) {
                lastOccurred[0] = end;
            }

            if (nums[end] == maxK) {
                lastOccurred[1] = end;
            }

            res += 1 + min(lastOccurred[0], lastOccurred[1]);
        }

        return res;
    }
};