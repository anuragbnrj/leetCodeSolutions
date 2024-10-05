class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        for (char ch : s1.toCharArray()) {
            freq1[ch - 'a'] += 1;
        }

        int[] freq2 = new int[26];
        for (int beg = 0, end = 0; end < s2.length(); end++) {
            char ch = s2.charAt(end);
            freq2[ch - 'a'] += 1;

            while ((end - beg + 1) > s1.length()) {
                ch = s2.charAt(beg);
                freq2[ch - 'a'] -= 1;
                beg += 1;
            }

            if ((end - beg + 1) == s1.length()) {
                if (compare(freq1, freq2)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean compare(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}