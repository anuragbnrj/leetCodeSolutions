class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        solve(n, n, new StringBuilder(), res);
        return res;
    }

    private void solve(int l, int r, StringBuilder currStr, List<String> res) {
        // System.out.println("idx: " + idx + ", currStr: " + currStr);
        if (l == 0 && r == 0) {
            res.add(currStr.toString());
            return;
        }

        if (l > 0) {
            currStr.append('(');
            solve(l - 1, r, currStr, res);
            currStr.deleteCharAt(currStr.length() - 1);
        }
        
        if (r > l) {
            currStr.append(')');
            solve(l, r - 1, currStr, res);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }
}