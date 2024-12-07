class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int beg = 1;
        int end = (int) 1e9 + 10;

        while (beg < end) {
            int mid = beg + ((end - beg) / 2);

            if (!isPossible(mid, maxOperations, nums)) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }

    private boolean isPossible(int minBalls, int maxOperations, int[] nums) {
        int opsReqd = 0;

        for (int num : nums) {
            if (num % minBalls == 0) {
                opsReqd += ((num / minBalls) - 1);
            } else {
                opsReqd += (num / minBalls);
            }

            if (opsReqd > maxOperations) return false;
        }

        return true;
    }
}