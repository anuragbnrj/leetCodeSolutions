class Solution {
    public int mirrorDistance(int n) {
        int reverse = 0;
        int temp = n;

        while (temp > 0) {
            int r = temp % 10;
            temp /= 10;

            reverse = reverse * 10 + r;
        }

        return Math.abs(n - reverse);
    }
}