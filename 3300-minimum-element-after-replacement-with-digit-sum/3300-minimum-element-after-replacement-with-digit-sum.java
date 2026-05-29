class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for (int num : nums) {
            int digitSum = 0;

            while (num > 0) {
                int r = num % 10;
                num /= 10;
                digitSum += r;
            }

            ans = Math.min(ans, digitSum);
        }

        return ans;
    }
}