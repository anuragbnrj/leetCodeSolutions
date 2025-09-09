class Solution {
    private int MOD = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] gotToKnow = new long[n + 2];
        long currKnow = 1;
        gotToKnow[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i - forget > 0) {
                currKnow = (((currKnow - gotToKnow[i - forget]) % MOD) + MOD) % MOD;
            }

            long cannotShare = 0;
            for (int j = 1; j < delay && i - j > 0; j++) {
                cannotShare = (cannotShare + gotToKnow[i - j]) % MOD;
            }

            gotToKnow[i] = (currKnow - cannotShare) % MOD;
            currKnow = (currKnow + ((currKnow - cannotShare + MOD) % MOD)) % MOD;

            // System.out.println("i: " + i + ", currKnow: " + currKnow);
        }

        return (int) currKnow;
    }
}