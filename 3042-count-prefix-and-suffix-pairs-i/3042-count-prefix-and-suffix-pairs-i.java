class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int len = words.length;

        int ans =  0;
        for (int i = 0; i < len; i++) {
            String currWord = words[i];
            for (int j = i + 1; j < len; j++) {
                String otherWord = words[j];

                if (otherWord.startsWith(currWord) && otherWord.endsWith(currWord)) {
                    ans += 1;
                }
            }
        }

        return ans;
    }
}