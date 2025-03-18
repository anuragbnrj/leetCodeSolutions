class Solution {
    public int longestNiceSubarray(int[] nums) {
        int len = nums.length;
        int[] bitFreq = new int[32];

        int ans = 1;
        int left = 0, right = -1;
        while (left < len) {
            while (right + 1 < len && canTake(nums[right + 1], bitFreq)) {
                right += 1;
                addBitFreq(nums[right], bitFreq);
            }

            ans = Math.max(ans, right - left + 1);

            if (left <= right) {
                subtractBitFreq(nums[left], bitFreq);
                left += 1;
            } else {
                left += 1;
                right = left - 1;
            }
        }

        return ans;
    }

    private boolean canTake(int num, int[] bitFreq) {
        for (int bit = 0; bit < 32; bit++) {
            int res = 1 << bit & num;

            if (res > 0 && bitFreq[bit] > 0) {
                return false;
            }
        }

        return true;
    }

    private void addBitFreq(int num, int[] bitFreq) {
        for (int bit = 0; bit < 32; bit++) {
            int res = 1 << bit & num;

            if (res > 0) {
                bitFreq[bit] += 1;
            }
        }
    }

    private void subtractBitFreq(int num, int[] bitFreq) {
        for (int bit = 0; bit < 32; bit++) {
            int res = (1 << bit) & num;

            if (res > 0) {
                bitFreq[bit] -= 1;
            }
        }
    }
}