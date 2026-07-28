class Solution {
    public String smallestPalindrome(String s) {
        int size = s.length();
        int[] freq = new int[26];

        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a'] += 1;
        }

        char[] ansArr = new char[size];
        int beg = 0;
        int end = size - 1;
        char mid = '\0';
        for (int i = 0; i < 26; i++) {
            char curr = (char) ('a' + i);
            while (freq[i] > 1) {
                ansArr[beg++] = curr;
                ansArr[end--] = curr;

                freq[i] -= 2;
            }

            if (freq[i] == 1) {
                mid = curr;
            }
        }

        if (mid != '\0') {
            ansArr[size / 2] = mid;
        }

        return String.valueOf(ansArr);
    }
}