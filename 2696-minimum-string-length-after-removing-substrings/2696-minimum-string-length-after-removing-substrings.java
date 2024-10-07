class Solution {
    public int minLength(String s) {
        int len = s.length();

        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == 'B') {
                if (st.size() > 0 && st.peek() == 'A') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            } else if  (ch == 'D') {
                if (st.size() > 0 && st.peek() == 'C') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            } else {
                st.push(ch);
            }
        }

        return st.size();   
    }
}