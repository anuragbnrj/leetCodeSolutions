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

        int prefixMatches = getPrefixMatches(larger, smaller);
        int suffixMatches = getSuffixMatches(larger, smaller);

        if (prefixMatches + suffixMatches >= smaller.length) {
            return true;
        }

        return false;
        
    }

    private int getPrefixMatches(String[] text, String[] pattern) {
        int matches = 0;
        for (int ptr1 = 0, ptr2 = 0; ptr1 < text.length && ptr2 < pattern.length; ptr1++, ptr2++) {
            if (!text[ptr1].equals(pattern[ptr2])) {
                break;
            } else {
                matches += 1;
            }
        }

        return matches;
    }

    private int getSuffixMatches(String[] text, String[] pattern) {
        int matches = 0;
        for (int ptr1 = text.length - 1, ptr2 = pattern.length - 1; ptr1 >= 0 && ptr2 >= 0; ptr1--, ptr2--) {
            if (!text[ptr1].equals(pattern[ptr2])) {
                break;
            } else {
                matches += 1;
            }
        }

        return matches;
    }
}