class Solution {
    public int minAddToMakeValid(String s) {
        char[] sarr = s.toCharArray();
        int len = sarr.length;

        Stack<Character> st = new Stack<>();
        for (char ch : sarr) {
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() > 0 && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }

        return st.size();
    }
}