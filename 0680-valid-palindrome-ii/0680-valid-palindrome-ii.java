class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();

        int beg = 0;
        int end = len - 1;
        boolean ans = palindromeCheck(0, len - 1, s);
        while (beg <= end) {
            if (s.charAt(beg) != s.charAt(end)) {
                ans = ans || palindromeCheck(beg + 1, end, s) || palindromeCheck(beg, end - 1, s);
                break; 
            } else {
                beg += 1;
                end -= 1;
            }
        }

        return ans;
    }

    private boolean palindromeCheck(int beg, int end, String s) {
        while (beg < end) {
            if (s.charAt(beg) != s.charAt(end)) {
                return false;
            } else {
                beg += 1;
                end -= 1;
            }
        }

        return true;
    }
}