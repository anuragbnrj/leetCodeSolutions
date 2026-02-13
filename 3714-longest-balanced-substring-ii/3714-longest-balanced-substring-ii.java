class Solution {

    public int longestBalanced(String s) {
        int best1 = longestSingleCharRun(s);
        int best2 = longestTwoCharBalanced(s);
        int best3 = longestThreeCharBalanced(s);
        return Math.max(best1, Math.max(best2, best3));
    }

    private int longestSingleCharRun(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int best = 1;
        int run = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                run++;
            } else {
                best = Math.max(best, run);
                run = 1;
            }
        }
        best = Math.max(best, run);
        return best;
    }

    private int longestTwoCharBalanced(String s) {
        int best = 0;
        best = Math.max(best, longestBalancedForPair(s, 'a', 'b'));
        best = Math.max(best, longestBalancedForPair(s, 'a', 'c'));
        best = Math.max(best, longestBalancedForPair(s, 'b', 'c'));
        return best;
    }

    private int longestBalancedForPair(String s, char c1, char c2) {
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int balance = 0;
        int best = 0;

        // balance 0 occurs before the string starts
        firstIndex.put(0, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // barrier: a third character appears
            if (ch != c1 && ch != c2) {
                balance = 0;
                firstIndex = new HashMap<>();
                firstIndex.put(0, i); // new segment starts after i
                continue;
            }

            if (ch == c1) {
                balance++;
            } else { // ch == c2
                balance--;
            }

            Integer prev = firstIndex.get(balance);
            if (prev != null) {
                best = Math.max(best, i - prev);
            } else {
                firstIndex.put(balance, i);
            }
        }

        return best;
    }

    private int longestThreeCharBalanced(String s) {
        int a = 0, b = 0, c = 0;
        Map<DiffKey, Integer> firstIndex = new HashMap<>();
        int best = 0;

        firstIndex.put(new DiffKey(0, 0), -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                b++;
            } else { // 'c'
                c++;
            }

            DiffKey key = new DiffKey(a - b, b - c);
            Integer prev = firstIndex.get(key);
            if (prev != null) {
                best = Math.max(best, i - prev);
            } else {
                firstIndex.put(key, i);
            }
        }

        return best;
    }

    // Small immutable key for (a-b, b-c)
    private static final class DiffKey {
        private final int d1;
        private final int d2;

        DiffKey(int d1, int d2) {
            this.d1 = d1;
            this.d2 = d2;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof DiffKey)) return false;
            DiffKey other = (DiffKey) obj;
            return d1 == other.d1 && d2 == other.d2;
        }

        @Override
        public int hashCode() {
            return 31 * d1 + d2;
        }
    }
}