class Solution {
public:
    int MOD = 1e9 + 7;
    int countGoodNumbers(long long n) {
        long long evenPos = ((n + 1) / 2);
        long long oddPos = (n / 2);

        long long s1 = binPowMod(5, evenPos, MOD);
        long long s2 = binPowMod(4, oddPos, MOD);

        long long sum = (s1 * s2) % MOD;
        
        return sum;
    }

private:
    long long binPowMod(long long a, long long b, long long m) {
        a %= m;
        long long res = 1;
        while (b > 0) {
            if (b & 1)
                res = (res * a) % m;
            a =(a * a) % m;
            b >>= 1;
        }
        return res;
    }
};