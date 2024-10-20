class Solution {
    public boolean parseBoolExpr(String expression) {
        int len = expression.length();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            char curr = expression.charAt(i);
            
            if (curr == ')') {
                ArrayList<Boolean> values = new ArrayList<>();
                while (st.peek() != '(') {
                    char top = st.pop();

                    if (top == 'f') {
                        values.add(false);
                    } else if (top == 't') {
                        values.add(true);
                    }
                }
                st.pop(); // For (

                // For the operator
                char top = st.pop();
                boolean ans = false;
                System.out.println(top);
                if (top == '!') {
                    ans = !(values.get(0));
                } else if (top == '|') {
                    ans = false;
                    for (Boolean value : values) {
                        ans = ans | value;
                    }
                } else if (top == '&') {
                    ans = true;
                    for (boolean value : values) {
                        ans = ans & value;
                    }
                }

                if (ans == false) {
                    st.push('f');
                } else {
                    st.push('t');
                }
            } else {
                st.push(curr);
            }
        }

        char ch = st.pop();
        if (ch == 'f') {
            return false;
        }
        return true;
    }
}