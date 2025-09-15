class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        
        Set<Character> unusable = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            unusable.add(ch);
        }

        int ans = 0;
        for (String word: words) {
            if (canBeTyped(word, unusable)) {
                ans += 1;
            }
        }
        
        return ans;
    }

    private boolean canBeTyped(String word, Set<Character> unusable) {

        for (char ch : word.toCharArray()) {
            if (unusable.contains(ch)) {
                return false;
            }
        }

        return true;
    }
}