class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length();

        int[] diff1 = new int[26];
        int[] diff2 = new int[26];
        int diffCount = 0;
        for (int i = 0; i < len; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (ch1 != ch2) {
                diffCount += 1;
                diff1[ch1 - 'a'] += 1;
                diff2[ch2 - 'a'] += 1;
            }
        }

        if (diffCount == 0) {
            return true;
        } else if (diffCount == 1) {
            return false;
        } else if (diffCount == 2) {
            for (int i = 0; i < 26; i++) {
                if (diff1[i] != diff2[i]) {
                    return false;
                }
            }

            return true;

        } else {
            return false;
        }
         
    }
}