class Solution {
    private final long MOD = (long) 1e9 + 7;

    public int numSub(String s) {
        int len = s.length();

        long consecutiveOnes = 0;
        long ans = 0;
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (ch == '1') {
                consecutiveOnes += 1;
            } else {
                ans += ((consecutiveOnes * (consecutiveOnes + 1)) / 2);
                consecutiveOnes = 0;
            }
        }

        if (consecutiveOnes > 0) {
            ans += ((consecutiveOnes * (consecutiveOnes + 1)) / 2);
        }
        ans = ans % MOD;

        return (int) ans;
    }
}