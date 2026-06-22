class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> balloonFreq = Map.of('b', 1, 'a', 1, 'l', 2, 'o', 2, 'n', 1);

        int[] freq = new int[26];
        for (char ch : text.toCharArray()) {
            freq[ch - 'a'] += 1;
        }

        int ans = 100005;
        for (char ch : balloonFreq.keySet()) {
            int req = balloonFreq.get(ch);

            int present = freq[ch - 'a'];

            int possible = present / req;

            ans = Math.min(ans, possible);
        }

        return ans;
    }
}