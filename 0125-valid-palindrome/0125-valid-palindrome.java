class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int len = s.length();

        for (int beg = 0, end = len - 1; beg < end;) {
            char left = s.charAt(beg);
            char right = s.charAt(end);

            if (!Character.isLetterOrDigit(left)) {
                beg += 1;
            } else if (!Character.isLetterOrDigit(right)) {
                end -= 1;
            } else {
                if (left == right) {
                    beg += 1;
                    end -= 1;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}