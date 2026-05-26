class Solution {
    public int numberOfSpecialChars(String word) {
        int[] upper = new int[26];
        int[] lower = new int[26];

        for (char ch : word.toCharArray()) {
            if (ch < 'a') {
                upper[ch - 'A'] += 1;
            } else {
                lower[ch - 'a'] += 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (upper[i] > 0 && lower[i] > 0) {
                ans += 1;
            }
        }

        return ans;
    }
}