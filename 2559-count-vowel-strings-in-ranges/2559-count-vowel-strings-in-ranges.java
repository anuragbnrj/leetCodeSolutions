class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len = words.length;
        int[] prefixSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int l = query[0] + 1;
            int r = query[1] + 1;

            ans[i] = prefixSum[r] - prefixSum[l - 1];
        }

        return ans;
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;

        return false;
    }
}