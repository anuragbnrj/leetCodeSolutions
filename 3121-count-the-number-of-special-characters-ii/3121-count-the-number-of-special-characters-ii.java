class Solution {
    public int numberOfSpecialChars(String word) {
        int[] firstUpper = new int[26];
        Arrays.fill(firstUpper, -1);
        int[] lastLower = new int[26];
        Arrays.fill(lastLower, -1);

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch < 'a' && firstUpper[ch - 'A'] == -1) {
                firstUpper[ch - 'A'] = i;
            }

            if (ch >= 'a') {
                lastLower[ch - 'a'] = i;
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (firstUpper[i] != -1 && lastLower[i] != -1 && lastLower[i] < firstUpper[i]) {
                ans += 1;
            }
        }

        return ans;
    }
}