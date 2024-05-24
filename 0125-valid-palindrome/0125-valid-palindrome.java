class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ('a' <= ch && ch <= 'z') {
                temp.append(ch);
            }
        }

        int len = temp.length();
        for (int beg = 0, end = len - 1; beg <= end; beg++, end--) {
            if (temp.charAt(beg) != temp.charAt(end)) {
                return false;
            }
        }

        return true;
    }
}