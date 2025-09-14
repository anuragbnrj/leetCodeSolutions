class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] ans = new String[queries.length];

        Set<String> caseSensitive = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelsReplacedLowerCase = new HashMap<>();
        for (int i = 0; i < wordlist.length; i++) {
            String word = wordlist[i];
            caseSensitive.add(word);

            String wordLowerCase = word.toLowerCase();
            if (!caseInsensitive.containsKey(wordLowerCase)) {
                caseInsensitive.put(wordLowerCase, word);
            }

            String wordVowelsReplacedLowerCase = word.replaceAll("[AEIOUaeiou]", "-").toLowerCase();
            if (!vowelsReplacedLowerCase.containsKey(wordVowelsReplacedLowerCase)) {
                vowelsReplacedLowerCase.put(wordVowelsReplacedLowerCase, word);
            }
        }

        for (int q = 0; q < queries.length; q++) {
            String query = queries[q];
            String queryLowerCase = query.toLowerCase();
            String queryVowelsReplacedLowerCase = query.replaceAll("[AEIOUaeiou]", "-").toLowerCase();

            if (caseSensitive.contains(query)) {
                ans[q] = query;
            } else if (caseInsensitive.containsKey(queryLowerCase)) {
                ans[q] = caseInsensitive.get(queryLowerCase);
            } else if (vowelsReplacedLowerCase.containsKey(queryVowelsReplacedLowerCase)) {
                ans[q] = vowelsReplacedLowerCase.get(queryVowelsReplacedLowerCase);
            } else {
                ans[q] = "";
            }
        }

        return ans;
    }
}