class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> balloonFreq = new HashMap<>();
        balloonFreq.put('b', 1);
        balloonFreq.put('a', 1);
        balloonFreq.put('l', 2);
        balloonFreq.put('o', 2);
        balloonFreq.put('n', 1);

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

        return ans == 100005 ? 0 : ans;
    }
}