class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int len = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        long ans = 0;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];

            int gteIdx = getFirstIdxGreaterThanEqual(nums, lower - curr);
            int lteIdx = getLastIdxLesserThanEqual(nums, upper - curr);

            // System.out.println("lower: " + lower + ", upper: " + upper + ", idx: " + i + ", curr: " + curr + ", gteIdx: " + gteIdx + ", lteIdx: " + lteIdx);

            int i1left = 0, i1right = lteIdx;
            int i2left = gteIdx, i2right = len - 1;

            int left = Math.max(i1left, i2left);
            int right = Math.min(i1right, i2right);

            long overlap = right - left + 1;

            if (overlap > 0) {
                ans += (overlap);

                if (left <= i && i <= right) {
                    ans -= 1;
                }
            }
        }

        return ans / 2;
    }

    private int getFirstIdxGreaterThanEqual(int[] nums, int el) {
        int beg = 0;
        int end = nums.length;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (nums[mid] < el) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }

    private int getLastIdxLesserThanEqual(int[] nums, int el) {
        int beg = 0;
        int end = nums.length;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (nums[mid] <= el) beg = mid + 1;
            else end = mid;
        }

        return beg - 1;
    }
}