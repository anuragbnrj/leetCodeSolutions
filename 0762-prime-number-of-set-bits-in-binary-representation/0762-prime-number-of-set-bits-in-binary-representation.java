class Solution {

    private static final boolean[] IS_PRIME = new boolean[32];
    
    static {
        IS_PRIME[2] = IS_PRIME[3] = IS_PRIME[5] = IS_PRIME[7] = IS_PRIME[11] = IS_PRIME[13] = IS_PRIME[17] = IS_PRIME[19] = true;
    }

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);

            if (IS_PRIME[setBits]) {
                ans += 1;
            }
        }

        return ans;
    }
}