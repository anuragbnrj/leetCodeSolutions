class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int[] pl = new int[n];
        for (int i = 0; i < n; i++) {
            pl[i] = -1;

            int curr = heights[i];
            
            while(st.size() > 0 && curr < heights[st.peek()]) {
                st.pop();
            }

            if (st.size() > 0) {
                pl[i] = st.peek();
            }

            st.push(i);
        }

        int[] nl = new int[n];
        for (int i = 0; i < n; i++) {
            nl[i] = n;

            int curr = heights[i];
            
            while(st.size() > 0 && curr < heights[st.peek()]) {
                int top = st.pop();
                nl[top] = i;
            }

            st.push(i);
        }


        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pl[i] - 1;
            int right = nl[i] - 1 - i;

            int currContri = (left + right + 1) * heights[i];
            // System.out.println("i: " + i + ", pl[i]: " + pl[i] + ", nl[i]: " + nl[i] + ", currContri: " + currContri);
            ans = Math.max(ans, currContri);
        }

        return ans;
    }
}