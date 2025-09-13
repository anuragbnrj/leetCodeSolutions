class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];

        int maxVowel = 0, maxConsonant = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            freq[ch - 'a'] += 1;

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                maxVowel = Math.max(maxVowel, freq[ch - 'a']);
            } else {
                maxConsonant = Math.max(maxConsonant, freq[ch - 'a']);
            }
        }

        return maxVowel + maxConsonant;
    }
}