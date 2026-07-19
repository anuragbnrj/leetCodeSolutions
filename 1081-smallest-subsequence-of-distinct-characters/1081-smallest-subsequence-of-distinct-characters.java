class Solution {
    public String smallestSubsequence(String s) {
        int size = s.length();

        int[] lastOccurrence = new int[26];
        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);

            lastOccurrence[ch - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();
        boolean[] isPresent = new boolean[26];
        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);

            if (isPresent[ch - 'a']) {

            } else {
                while (!st.isEmpty() && st.peek() > ch && lastOccurrence[st.peek() - 'a'] > i) {
                    isPresent[st.peek() - 'a'] = false;
                    st.pop();
                }

                st.push(ch);
                isPresent[ch - 'a'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            char top = st.pop();

            sb.append(top);
        }
        
        return sb.reverse().toString();
    }
}