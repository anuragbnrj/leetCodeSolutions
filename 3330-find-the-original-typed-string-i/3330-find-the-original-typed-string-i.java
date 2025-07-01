class Solution {
    public int possibleStringCount(String word) {
        int[] repFreq = new int[101];

        int ans = 1;
        for (int beg = 0; beg < word.length(); ) {
            char curr = word.charAt(beg);
            int count = 0;
            int idx = beg;
            for ( ; idx < word.length() && (word.charAt(idx) == curr); idx++) {
               count += 1;
            }
            
            ans += count - 1;
            beg = idx;
        }

        return ans;
    }
}