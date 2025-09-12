class Solution {
    public boolean doesAliceWin(String s) {
        int vowels = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isVowel(ch)) {
                vowels += 1;
            }
        }

        if (vowels == 0) {
            return false;
        }

        return true;
    }

    public boolean isVowel(char c) {
        // Convert the character to lowercase to handle both uppercase and lowercase vowels
        char lowerCaseChar = Character.toLowerCase(c); 
        
        // Check if the lowercase character is present in a string of vowels
        return "aeiou".indexOf(lowerCaseChar) != -1; 
    }
}