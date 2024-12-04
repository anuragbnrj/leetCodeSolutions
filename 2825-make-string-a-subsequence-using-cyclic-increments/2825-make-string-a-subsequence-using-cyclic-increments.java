class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int len1 = str1.length();
        int ptr1 = 0;

        int len2 = str2.length();
        int ptr2 = 0;

        for(; ptr1 < len1 && ptr2 < len2; ) {
            char ch1 = str1.charAt(ptr1);
            char ch1Next = (char) ('a' + (((ch1 - 'a') + 1) % 26));

            char ch2 = str2.charAt(ptr2);

            if (ch1 == ch2 || ch1Next == ch2) {
                ptr1 += 1;
                ptr2 += 1;
            } else {
                ptr1 += 1;
            }
        }

        if (ptr2 >= len2) {
            return true;
        }

        return false;
    }
}