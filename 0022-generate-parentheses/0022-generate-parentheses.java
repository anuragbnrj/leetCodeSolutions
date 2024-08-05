class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        solve(0, n, new StringBuilder(), res);
        return res;
    }

    private void solve(int idx, int n, StringBuilder currStr, List<String> res) {
        // System.out.println("idx: " + idx + ", currStr: " + currStr);
        if (currStr.length() == (2 * n)) {
            if (isValid(currStr)) {
                String str = new String(currStr.toString());
                res.add(str);
            }
            return;
        }

        currStr.append('(');
        solve(idx + 1, n, currStr, res);
        currStr.deleteCharAt(currStr.length() - 1);

        currStr.append(')');
        solve(idx + 1, n, currStr, res);
        currStr.deleteCharAt(currStr.length() - 1);
    }

    private boolean isValid(StringBuilder currStr) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < currStr.length(); i++) {
            char ch = currStr.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() == 0 || st.peek() != '(') {
                    return false;
                } else {
                    st.pop();
                }
            }
        }

        if (st.size() > 0) {
            return false;
        }
        return true;
    }
}