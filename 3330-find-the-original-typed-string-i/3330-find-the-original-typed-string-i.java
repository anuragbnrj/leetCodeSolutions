class Solution {
    public int possibleStringCount(String word) {
        int[] repFreq = new int[101];

        for (int beg = 0; beg < word.length(); ) {
            char curr = word.charAt(beg);
            int count = 0;
            int idx = beg;
            for ( ; idx < word.length() && (word.charAt(idx) == curr); idx++) {
               count += 1;
            }
            repFreq[count] += 1;
            beg = idx;
        }

        int ans = 1;
        for (int i = 2; i <= 100; i++) {
            ans += (i - 1) * repFreq[i];
        }

        return ans;
    }
}