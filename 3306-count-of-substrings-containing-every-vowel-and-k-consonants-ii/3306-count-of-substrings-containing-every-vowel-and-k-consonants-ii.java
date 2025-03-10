class Solution {

    public long countOfSubstrings(String word, int k) {
        long a = countAtLeastKConsonants(word, k);
        long b = countAtLeastKConsonants(word, k + 1);

        return a - b;
    }

    private long countAtLeastKConsonants(String word, int k) {
        int len = word.length();

        HashMap<Character, Integer> vowels = new HashMap<>();
        long ans = 0;

        int left = 0;
        int right = -1;
        int consonantCount = 0;

        while (left < len) {

            while (right + 1 < len && (consonantCount < k || vowels.size() < 5)) {
                char curr = word.charAt(right + 1);
                if (isVowel(curr)) {
                    vowels.put(curr, vowels.getOrDefault(curr, 0) + 1);
                } else {
                    consonantCount += 1;
                }
                right++;
            }

            if (vowels.size() == 5 && consonantCount >= k) {
                ans += ((long) len - right);
            }

            if (left <= right) {
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    int count = vowels.getOrDefault(leftChar, 0);
                    if (count == 1) {
                        vowels.remove(leftChar);
                    } else {
                        vowels.put(leftChar, count - 1);
                    }
                } else {
                    consonantCount -= 1;
                }
                left++;
            } else {
                left++;
                right = left - 1;
            }
        }

        return ans;
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}