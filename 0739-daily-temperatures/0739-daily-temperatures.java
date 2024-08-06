class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] nge = new int[n];
        for (int i = 0; i < n; i++) {
            nge[i] = n;
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int currTemp = temperatures[i];
            while (st.size() > 0 && currTemp > temperatures[st.peek()]) {
                int top = st.pop();
                nge[top] = i;
            }

            st.push(i);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nge[i] != n) {
                ans[i] = nge[i] - i;
            } else {
                nge[i] = 0;
            }
        }

        return ans;
    }
}