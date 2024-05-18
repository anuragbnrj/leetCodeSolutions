class Solution {
public:
    long long findMaximumNumber(long long k, int x) {
        long long beg = 1;
        long long end = 1e15;

        while (beg < end) {
            long long mid = beg + (end - beg) / 2;

            if (isCheap(k, x, mid)) beg = mid + 1;
            else end = mid;
        }

        return (beg - 1);
    }

private:
    bool isCheap(long long k, int x, long long num) {
        long long accumulatedPrice = 0;
        for (int i = 0; i < 63; i++) {
            if ((i + 1) % x == 0) {
                accumulatedPrice += setBitsAtIdx(i, num);
            }
        }

        return (accumulatedPrice <= k);
    }

    long long setBitsAtIdx(int i, long long x) {
        long long nums = (x + 1);
        long long boxsize = (1LL << (i + 1));

        long long fullboxes = nums / boxsize;
        long long ans = fullboxes * (1LL << i);

        long long extra = nums % boxsize;
        ans += max(extra - (1LL << i), 0LL);
        return ans;
    }
};