class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        
        String word = "";
        String sentence = "";
        solve(0, s, dict, word, sentence, res);

        return res;
    }

    private void solve(int idx, String s, Set<String> dict, String word, String sentence, List<String> res) {
        word += s.charAt(idx);

        int n = s.length();
        if (idx == (n - 1)) {
            if (dict.contains(word)) {
                sentence += word;
                res.add(sentence);
            }
            return;
        }

        if (dict.contains(word)) {
            solve(idx + 1, s, dict, "", sentence + word + ' ', res);
        }
        solve(idx + 1, s, dict, word, sentence, res);
    }

}
