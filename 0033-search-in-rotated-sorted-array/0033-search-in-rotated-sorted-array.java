class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int beg = 0;
        int end = n;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (nums[mid] >= nums[0]) beg = mid + 1;
            else end = mid;
        }

        int minIdx = (beg % n);
        int[] res = find(nums, 0, minIdx, target);
        if (res[0] == 1) {
            return res[1];
        }

        res = find(nums, minIdx, n, target);
        return res[1];
    }

    private int[] find(int[] nums, int beg, int end, int target) {
        int l = beg;
        int r = end;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (nums[mid] < target) beg = mid + 1;
            else end = mid;
        }

        if (beg == r || nums[beg] != target) {
            return new int[]{0, -1};
        }

        return new int[]{1, beg};
    }
}