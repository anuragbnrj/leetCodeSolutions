class Solution {
    public int minimumPushes(String word) {
        Integer[] freq = new Integer[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = 0;
        }

        for (char ch : word.toCharArray()) {
            freq[ch - 'a'] += 1;
        }

        Arrays.sort(freq, Collections.reverseOrder());

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int mul = (i / 8) + 1;

            ans += (freq[i] * mul);
        }

        return ans;
    }
}