class Solution {
    public List<String> stringMatching(String[] words) {
        int len = words.length;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String curr = words[i];

            for (int j = 0; j < len; j++) {
                if (i == j) continue;

                String word = words[j];

                if (word.contains(curr)) {
                    ans.add(curr);
                    break;
                }
            }
        }

        return ans;
    }
}