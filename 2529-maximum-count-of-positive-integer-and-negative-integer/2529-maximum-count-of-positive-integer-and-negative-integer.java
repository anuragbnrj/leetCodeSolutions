class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;

        for (int num : nums) {
            if (num < 0) {
                neg += 1;
            }

            if (num > 0) {
                pos += 1;
            }
        }

        return Math.max(neg, pos);
    }
}