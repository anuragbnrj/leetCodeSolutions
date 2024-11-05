class Solution {
    public int minChanges(String s) {
        int len = s.length();

        int ans = 0;
        for (int i = 1; i < len; i += 2) {
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);

            if (curr != prev) {
                ans += 1;
            }
        }

        return ans;
    }
}