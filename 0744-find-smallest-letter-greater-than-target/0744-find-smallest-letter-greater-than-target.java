class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int beg = 0;
        int end = len;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (letters[mid] <= target) beg = mid + 1;
            else end = mid;
        }

        if (beg == len) return letters[0];

        return letters[beg];
    }
}