class Solution {
    public int countGoodNumbers(long n) {
        long ans = 1L;
        long mod = (long) 1e9 + 7;

        long evenExp = (n + 1) / 2;
        ans = (ans * binPowMod(5L, evenExp, mod)) % mod;

        long oddExp = (n / 2);
        ans = (ans * binPowMod(4L, oddExp, mod)) % mod;
        
        return (int) ans;
    }

    private long binPowMod(long base, long exp, long mod) {
        base %= mod;
        long res = 1;

        while (exp > 0) {
            if ((exp & 1) > 0) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }

        return res;
    }
}