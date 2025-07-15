class Solution {
    public boolean isValid(String word) {
        int len = word.length();
        if (len < 3) return false;

        int vowel = 0, consonant = 0;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);

            if (!Character.isLetterOrDigit(ch)) return false;

            if (isVowel(ch)) vowel += 1;
            if (isConsonant(ch)) consonant += 1;
        }

        if (vowel == 0 || consonant == 0) {
            return false;
        }
        return true;
    }

    private boolean isVowel(char c){
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    private boolean isConsonant(char c){
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1;
    }
}