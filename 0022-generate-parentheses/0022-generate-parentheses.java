class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        StringBuilder curr = new StringBuilder();

        generate(n, curr, 0, 0, ans);

        return ans;
    }

    private void generate(int n, StringBuilder curr, int open, int close, List<String> ans) {
        if (curr.length() == (2*n)) {
            ans.add(curr.toString());
            return;
        }

        if (open != n) {
            curr.append("(");
            generate(n, curr, open + 1, close, ans);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(")");
            generate(n, curr, open, close + 1, ans);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}