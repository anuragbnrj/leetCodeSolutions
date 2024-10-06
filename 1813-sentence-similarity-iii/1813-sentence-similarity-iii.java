class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int len1 = s1.length;
        int len2 = s2.length;

        String[] larger, smaller;
        if (len1 > len2) {
            larger = s1;
            smaller = s2;
        } else {
            larger = s2;
            smaller = s1;
        }

        int ptr1 = 0;
        int ptr2 = 0;
        boolean used = false;
        while (ptr1 < larger.length && ptr2 < smaller.length) {
            if (larger[ptr1].equals(smaller[ptr2])) {
                ptr1 += 1;
                ptr2 += 1;
            } else {
                if (used) {
                    return false;
                } else {
                    while (ptr1 < larger.length && !larger[ptr1].equals(smaller[ptr2])) {
                        ptr1 += 1;
                    }

                    used = true;
                }
            }
        }


        if (ptr2 != smaller.length) {
            return false;
        } else {
            if (used && ptr1 != larger.length) {
                return false;
            }
        }

        return true;
    }
}