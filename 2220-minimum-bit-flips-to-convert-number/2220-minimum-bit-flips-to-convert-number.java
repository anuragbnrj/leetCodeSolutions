class Solution {
    public int minBitFlips(int start, int goal) {
        int xorr = start ^ goal;

        int ans = 0;
        for (int i = 1; i <= 31; i++) {
            ans += (xorr & 1);

            xorr = xorr >> 1;
        }

        return ans;
    }
}