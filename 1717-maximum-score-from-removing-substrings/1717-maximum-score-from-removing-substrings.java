class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int ans = 0;
        if (x > y) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'b') {
                    if (st.size() > 0 && st.peek() == 'a') {
                        st.pop();
                        ans += x;
                    } else {
                        st.push(ch);
                    }
                } else {
                    st.push(ch);
                }
            }

            StringBuilder temp = new StringBuilder();
            while (st.size() > 0) {
                char top = st.peek();
                st.pop();
                temp.append(top);
            }
            temp.reverse();

            for (int i = 0; i < temp.length(); i++) {
                char ch = temp.charAt(i);
                if (ch == 'a') {
                    if (st.size() > 0 && st.peek() == 'b') {
                        st.pop();
                        ans += y;
                    } else {
                        st.push(ch);
                    }
                } else {
                    st.push(ch);
                }
            }
        } else {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'a') {
                    if (st.size() > 0 && st.peek() == 'b') {
                        st.pop();
                        ans += y;
                    } else {
                        st.push(ch);
                    }
                } else {
                    st.push(ch);
                }
            }

            StringBuilder temp = new StringBuilder();
            while (st.size() > 0) {
                char top = st.peek();
                st.pop();
                temp.append(top);
            }
            temp.reverse();

            for (int i = 0; i < temp.length(); i++) {
                char ch = temp.charAt(i);
                if (ch == 'b') {
                    if (st.size() > 0 && st.peek() == 'a') {
                        st.pop();
                        ans += x;
                    } else {
                        st.push(ch);
                    }
                } else {
                    st.push(ch);
                }
            }
        }

        return ans;
    }
}