class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                Queue<Character> temp = new LinkedList<>();

                while (st.peek() != '(') {
                    char top = st.peek();
                    st.pop();

                    temp.add(top);
                }

                st.pop();

                while (!temp.isEmpty()) {
                    char front = temp.peek();
                    temp.poll();

                    st.push(front);
                }
            } else {
                st.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            char top = st.peek();
            st.pop();

            ans.append(top);
        }

        return ans.reverse().toString();
    }
}