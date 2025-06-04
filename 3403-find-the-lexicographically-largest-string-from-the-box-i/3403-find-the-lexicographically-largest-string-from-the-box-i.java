class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;

        char largestCh = 'a';
        for (char ch : word.toCharArray()) {
            if (ch > largestCh) {
                largestCh = ch;
            }
        }

        String ans = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == largestCh) {
                String candidate;
                if (i >= numFriends - 1) {
                    candidate = word.substring(i);
                } else {
                    candidate = word.substring(i, word.length() - (numFriends - i - 1));
                }

                if (candidate.compareTo(ans) > 0) {
                    ans = candidate;
                }
            }
        }

        return ans;
    }
}