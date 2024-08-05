class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int op2 = st.pop();
                int op1 = st.pop();

                int res = 0;
                
                if (token.equals("+")) {
                    res = op1 + op2;
                } 

                if (token.equals("-")) {
                    res = op1 - op2;
                }

                if (token.equals("*")) {
                    res = op1 * op2;
                }

                if (token.equals("/")) {
                    res = op1 / op2;
                }

                st.push(res);
            } else {
                int op = Integer.parseInt(token);
                st.push(op);
            }
        }

        return st.peek();
        
    }
}