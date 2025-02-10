class Solution {
    public String clearDigits(String s) {
        char[] sarr = s.toCharArray();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < sarr.length; i++) {
            char curr = sarr[i];

            if (Character.isDigit(curr)) {
                st.pop();
            } else {
                st.push(curr);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            char top = st.pop();
            sb.append(top);
        }
        sb = sb.reverse();

        return sb.toString();
    }
}