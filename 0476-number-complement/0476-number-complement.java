class Solution {
    public int findComplement(int num) {
        int temp = num;

        int pow = 0, ans = 0;
        while (temp > 0) {
            int r = temp % 2;
            temp /= 2;

            ans += (int) Math.pow(2, pow) * (1 - r);
            pow += 1;
        }

        return ans;
    }
}