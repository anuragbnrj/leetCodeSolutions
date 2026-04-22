class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int size = queries.length;

        List<String> ans = new ArrayList<>();
        for (String query : queries) {
            for (String word : dictionary) {
                if (isWithinTwoEdits(query, word)) {
                    ans.add(query);
                    break;
                }
            }
        }
        
        return ans;
    }

    private boolean isWithinTwoEdits(String src, String target) {
        int size = src.length();

        int diff = 0;
        for (int i = 0; i < size; i++) {
            if (src.charAt(i) != target.charAt(i)) {
                diff += 1;
            }
        }

        return (diff <= 2);
    }
}