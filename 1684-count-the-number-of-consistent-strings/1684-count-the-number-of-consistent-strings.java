class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] isPresent = new boolean[26];
        for (char ch : allowed.toCharArray()) {
            isPresent[ch - 'a'] = true;
        }

        int ans = 0;
        for (String word : words) {
            int present = 0;
            for (char ch : word.toCharArray()) {
                if (isPresent[ch - 'a']) {
                    present += 1;
                } else {
                    break;
                }
            }

            if (present == word.length()) {
                ans += 1;
            }
        }

        return ans;
    }
}