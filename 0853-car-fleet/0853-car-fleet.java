class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] details = new int[n][2];
        for (int i = 0; i < n; i++) {
            details[i][0] = position[i];
            details[i][1] = speed[i];
        }

        Arrays.sort(details, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        boolean[] nge = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {

            while (st.size() > 0 && 
            ((target - details[i][0]) * details[st.peek()][1]) >= ((target - details[st.peek()][0]) * details[i][1])) {
                int top = st.pop();
                nge[top] = true;
            }

            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nge[i] == false) {
                ans += 1;
            }
        }

        return ans;
    }
}