class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int zerocount = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zerocount++;
        }

        if (zerocount == 0) return 0;
        
        // Special case: k == n
        // We flip the entire string.
        // We can only solve it if everything is '0' (1 op) or '1' (0 ops).
        // Since zerocount > 0 here, must be all '0's.
        if (k == n) {
            return (zerocount == n) ? 1 : -1;
        }

        int ans = Integer.MAX_VALUE;

        // Case 1: Try to find an Even m
        // Condition: Parity of total flips (m*k) must match Z.
        // If m is even, m*k is even. So Z must be even.
        if (zerocount % 2 == 0) {
            // Formula: max( ceil(Z/k), ceil(Z / (n-k)) )
            int term1 = (zerocount + k - 1) / k;
            int term2 = (zerocount + (n - k) - 1) / (n - k);
            int m = Math.max(term1, term2);
            
            // Align to Even
            if (m % 2 != 0) m++;
            ans = m;
        }

        // Case 2: Try to find an Odd m
        // Condition: Parity of total flips (m*k) must match Z.
        // If m is odd, m*k has same parity as k. So Z % 2 == k % 2.
        if (zerocount % 2 == k % 2) {
            // Formula: max( ceil(Z/k), ceil((n-Z) / (n-k)) )
            int term1 = (zerocount + k - 1) / k;
            int term2 = (n - zerocount + (n - k) - 1) / (n - k);
            int m = Math.max(term1, term2);
            
            // Align to Odd
            if (m % 2 == 0) m++;
            ans = Math.min(ans, m);
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
