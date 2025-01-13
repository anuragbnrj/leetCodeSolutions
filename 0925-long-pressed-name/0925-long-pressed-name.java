class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int ptr1 = 0;
        int ptr2 = 0;

        char prev = '*';
        while (ptr1 < name.length() && ptr2 < typed.length()) {
            char ch1 = name.charAt(ptr1);
            char ch2 = typed.charAt(ptr2);

            if (ch1 == ch2) {
                ptr1 += 1;
                ptr2 += 1;

                prev = ch1;
            } else {
                if (ch2 == prev) {
                    ptr2 += 1;
                } else {
                    return false;
                }
            }
        }

        while (ptr2 < typed.length()) {
            char ch2 = typed.charAt(ptr2);

            if (ch2 == prev) {
                ptr2 += 1;
            } else {
                return false;
            }
        }

        if (ptr1 != name.length() || ptr2 != typed.length()) {
            return false;
        }

        return true;
    }
}