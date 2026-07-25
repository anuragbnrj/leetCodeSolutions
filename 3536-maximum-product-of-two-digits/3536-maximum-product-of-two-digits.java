class Solution {
    public int maxProduct(int n) {
        int max = -1, secondMax = -2;

        int temp = n;
        while (temp > 0) {
            int r = temp % 10;

            if (r > max) {
                secondMax = max;
                max = r;
            } else if (r > secondMax) {
                secondMax = r;
            }

            temp /= 10;
        }

        return max * secondMax;
    }
}