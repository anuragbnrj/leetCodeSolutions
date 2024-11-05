class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> comp = new HashMap<>();
        comp.put(')', '(');
        comp.put('}', '{');
        comp.put(']', '[');

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.size() == 0) {
                    return false;
                }

                if (st.peek() == comp.get(ch)) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}