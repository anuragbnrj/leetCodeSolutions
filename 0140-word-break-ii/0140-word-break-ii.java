class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();

        rec(0, s, "", new ArrayList<>(), dict, ans);
        return ans;
    }

    private void rec(int idx, String s, String prevWord, List<String> currentWords, Set<String> dict, List<String> ans) {
        if (idx == s.length()) {
            if (prevWord.length() == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < currentWords.size() - 1; i++) {
                    sb.append(currentWords.get(i));
                    sb.append(" ");
                }
                sb.append(currentWords.get(currentWords.size() - 1));

                ans.add(sb.toString());
            }
            
            return;
        }

        char ch = s.charAt(idx);
        String currWord = prevWord + ch;
        if (dict.contains(currWord)) {
            currentWords.add(currWord);
            rec(idx + 1, s, "", currentWords, dict, ans);
            currentWords.remove(currentWords.size() - 1);
        }

        rec(idx + 1, s, currWord, currentWords, dict, ans);
    }
}