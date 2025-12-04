class Solution {
    public int countCollisions(String directions) {
        /*
            -1  - Moving Left
            0   - Stationary
            1   - Moving Right
        */
        Stack<Integer> st = new Stack<>();
        int stationary = 0;
        int ans = 0;
        for (char ch : directions.toCharArray()) {
            if (ch == 'L') {
                if (st.isEmpty()) {
                    if (stationary > 0) ans += 1;
                } else {
                    st.pop();
                    ans += 2;
                    stationary += 1;

                    while (!st.isEmpty()) {
                        st.pop();
                        ans += 1;
                        stationary += 1;
                    }
                    
                }
            } else if (ch == 'S') {
                if (st.isEmpty()) {
                    stationary += 1;
                } else {
                    while (!st.isEmpty()) {
                        st.pop();
                        ans += 1;
                        stationary += 1;
                    }
                }
            } else if (ch == 'R') {
                st.push(1);
            }

            // System.out.println("ans: " + ans);
        }

        return ans;
    }
}