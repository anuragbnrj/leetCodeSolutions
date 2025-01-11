class Solution {
    public boolean canConstruct(String s, int k) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a'] += 1;
        }

        int oddFreqCount = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddFreqCount += 1;
            }
        }

        if (oddFreqCount > k) {
            return false;
        }

        return true;
    }
}