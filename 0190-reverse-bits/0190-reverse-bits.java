class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & n) > 0) {
                ans = ans | (1 << (31 - i));
            }
        }

        return ans;
    }
}