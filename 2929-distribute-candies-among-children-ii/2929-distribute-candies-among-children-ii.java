class Solution {
    public long distributeCandies(int n, int limit) {
        if (1L * n > 3L * limit) return 0L;

        long ans = 0;
        for (long c1 = 0; c1 <= Math.min(n, limit); c1++) {
            long left = n - c1;

            if (limit >= left) {
                ans += (left + 1);
            } else {
                if (2L * limit < left)  {

                } else if (2L * limit == left) {
                    ans += 1;
                } else {
                    ans += 2 * limit - left + 1;
                }
            }

            // System.out.println("c1: " + c1 + ", ans: " + ans);
        }

        return ans;
    }
}