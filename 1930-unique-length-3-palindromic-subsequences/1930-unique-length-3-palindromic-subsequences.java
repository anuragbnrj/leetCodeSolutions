class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] strarr = s.toCharArray();
        int len = s.length();

        int[] firstOccurrence = new int[26];
        Arrays.fill(firstOccurrence, -1);
        for (int i = 0; i < len; i++) {
            char ch = strarr[i];
            if (firstOccurrence[ch - 'a'] == -1) {
                firstOccurrence[ch - 'a'] = i; 
            }
        }

        int[] lastOccurrence = new int[26];
        Arrays.fill(lastOccurrence, -1);
        for (int i = len - 1; i >= 0; i--) {
            char ch = strarr[i];
            if (lastOccurrence[ch - 'a'] == -1) {
                lastOccurrence[ch - 'a'] = i;
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int left = firstOccurrence[i] + 1;
            int right = lastOccurrence[i] - 1;

            ans += countUnique(strarr, left, right);
        }
        
        return ans;
    }

    private int countUnique(char[] strarr, int left, int right) {
        Set<Character> uniqueChars = new HashSet<>();

        for (int i = left; i <= right; i++) {
            uniqueChars.add(strarr[i]);
        }

        return uniqueChars.size();
    }
}