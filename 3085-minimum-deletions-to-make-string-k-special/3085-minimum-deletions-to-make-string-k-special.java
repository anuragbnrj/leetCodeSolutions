class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'a'] += 1;
        }

        int ans = (int) 1e9;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            int curr = freq[i];
            int dels = 0;

            for (int j = 0; j < 26; j++) {
                if (i == j || freq[j] == 0) continue;

                if (freq[j] < curr) {
                    dels += freq[j];
                } else if (freq[j] > curr) {
                    dels += Math.max(0, freq[j] - freq[i] - k);
                }
            }

            // System.out.println("i: " + i + ", dels: " + dels);
            ans = Math.min(ans, dels);
        }

        return ans;
    }
}