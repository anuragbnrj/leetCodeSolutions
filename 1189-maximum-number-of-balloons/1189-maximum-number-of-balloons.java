class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] textFreq = new int[26];
        for (char ch : text.toCharArray()) {
            textFreq[ch - 'a'] += 1;
        }
        
        String pattern = "balloon";
        int[] patternFreq = new int[26];
        for (char ch : pattern.toCharArray()) {
            patternFreq[ch - 'a'] += 1;
        }

        int ans = (int) 1e9;
        for (int i = 0; i < 26; i++) {
            if (patternFreq[i] != 0) {
                ans = Math.min(ans, textFreq[i] / patternFreq[i]);
            }
        }

        return ans;
    }
}