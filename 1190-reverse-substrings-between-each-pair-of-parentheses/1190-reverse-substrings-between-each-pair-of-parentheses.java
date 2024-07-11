class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        
        // First pass to find complements
        Stack<Integer> st = new Stack<>();
        int[] complement = new int[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            }

            if (ch == ')') {
                int top = st.peek();
                st.pop();

                complement[top] = i;
                complement[i] = top;
            }
        }

        // Second pass to build results
        StringBuilder res = new StringBuilder();
        for (int i = 0, direction = 1; i < n; i += direction) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                i = complement[i];
                direction = -1 * direction;
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }
}