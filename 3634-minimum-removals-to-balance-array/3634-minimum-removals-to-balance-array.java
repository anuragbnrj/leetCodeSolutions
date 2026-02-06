class Solution {
    public int minRemoval(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int possibleMax = k * nums[i];

            int upBound = upperBound(nums, possibleMax);

            int deletions = i + (len - upBound);
            ans = Math.min(ans, deletions);
        }

        return ans;
    }

    private int upperBound(int[] nums, int src) {
        int beg = 0;
        int end = nums.length;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (nums[mid] <= src) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }
}