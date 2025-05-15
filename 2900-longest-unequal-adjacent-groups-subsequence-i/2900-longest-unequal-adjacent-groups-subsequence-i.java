class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int len = words.length;

        List<String> start0 = getLongestStartingWith(1, words, groups);
        List<String> start1 = getLongestStartingWith(0, words, groups);

        if (start0.size() > start1.size()) {
            return start0;
        }
        return start1;
    }

    private List<String> getLongestStartingWith(int prev, String[] words, int[] groups) {
        int len = words.length;

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (groups[i] == prev) continue;

            prev = groups[i];
            ans.add(words[i]);
        }

        return ans;
    }
}