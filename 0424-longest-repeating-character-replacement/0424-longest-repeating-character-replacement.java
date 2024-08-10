class Solution {
    public int characterReplacement(String s, int k) {
        char[] sarr = s.toCharArray();
        int n = sarr.length;

        int head = -1, tail = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int ans = 0;
        while (tail < n) {
            while (head + 1 < n) {
                head += 1;
                char ch = sarr[head];

                freq[ch - 'A'] += 1;
                maxFreq = Math.max(maxFreq, freq[ch - 'A']);
                int replaceable = (head - tail + 1) - maxFreq;

                if (replaceable > k) {
                    head -= 1;
                    freq[ch - 'A'] -= 1;
                    for (int i = 0; i < 26; i++) {
                        maxFreq = Math.max(maxFreq, freq[i]);
                    }
                    break;
                }
            }

            ans = Math.max(ans, (head - tail + 1));

            if (head < tail) {
                tail += 1;
                head = tail - 1;
            } else {
                char ch = sarr[tail];
                freq[ch - 'A'] -= 1;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, freq[i]);
                }
 
                tail += 1;
            }
        }
        
        return ans;   
    }
}