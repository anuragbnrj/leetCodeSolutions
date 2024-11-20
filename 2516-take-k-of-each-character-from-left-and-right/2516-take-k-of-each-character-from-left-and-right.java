class Solution {
    public int takeCharacters(String s, int k) {
        int[] freq = new int[3];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'] += 1;
        }

        for (int i = 0; i < 3; i++) {
            if (freq[i] < k) {
                return -1;
            }
        }

        int maxLen = -1;
        int[] windowFreq = new int[3];
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            windowFreq[ch - 'a'] += 1;

            while (left <= right && ((windowFreq[0] > freq[0] - k) || (windowFreq[1] > freq[1] - k) || (windowFreq[2] > freq[2] - k) ) ) {
                ch = s.charAt(left);

                windowFreq[ch - 'a'] -= 1;
                left += 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        } 

        return s.length() - maxLen;
    }
}