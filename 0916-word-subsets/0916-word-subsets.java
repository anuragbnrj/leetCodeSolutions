class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int len1 = words1.length;
        int[][] freq1 = new int[len1][26];
        for (int i = 0; i < len1; i++) {
            String word = words1[i];
            for (char ch : word.toCharArray()) {
                freq1[i][ch - 'a'] += 1;
            }
        }

        int len2 = words2.length;
        int[] freq2 = new int[26];
        for (int i = 0; i < len2; i++) {
            String word = words2[i];
            int[] tempFreq = new int[26];
            for (char ch : word.toCharArray()) {
                tempFreq[ch - 'a'] += 1;
            }

            for (int j = 0; j < 26; j++) {
                freq2[j] = Math.max(freq2[j], tempFreq[j]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            boolean contains = true;
            for (int j = 0; j < 26; j++) {
                if (freq1[i][j] < freq2[j]) {
                    contains = false;
                    break;
                }
            }

            if (contains) {
                ans.add(words1[i]);
            }
        }

        return ans;
    }
}