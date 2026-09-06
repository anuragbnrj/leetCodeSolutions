class Solution {
    private HashMap<Pair<Integer, Integer>, Integer> memo;

    private int recurse(String s, String t, int i, int j) {
        int M = s.length();
        int N = t.length();

        if (i == M || j == N || M - i < N - j) {
            return j == t.length() ? 1 : 0;
        }

        Pair<Integer, Integer> key = new Pair<Integer, Integer>(i, j);

        if (this.memo.containsKey(key)) {
            return this.memo.get(key);
        }

        int ans = this.recurse(s, t, i + 1, j);

        if (s.charAt(i) == t.charAt(j)) {
            ans += this.recurse(s, t, i + 1, j + 1);
        }

        this.memo.put(key, ans);
        return ans;
    }

    public int numDistinct(String s, String t) {
        this.memo = new HashMap<Pair<Integer, Integer>, Integer>();
        return this.recurse(s, t, 0, 0);
    }
}