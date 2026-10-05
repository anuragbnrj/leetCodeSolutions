class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> st = new Stack<>();

        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(Character.toString(ch));
            }

            if (ch == ')') {
                int score = 0;
                while (!st.peek().equals("(")) {
                    String top = st.pop();
                    score += Integer.parseInt(top);
                }

                st.pop();

                if (score == 0) {
                    st.push("1");
                } else {
                    st.push(Integer.toString(2 * score));
                }
            }
        }

        while (!st.isEmpty()) {
            String top = st.pop();
            ans += Integer.parseInt(top);
        }

        return ans;
    }
}