import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] height = new int[rows][cols];

        // Build height matrix
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0) {
                    height[r][c] = (matrix[r][c] == '1') ? 1 : 0;
                } else {
                    if (matrix[r][c] == '1') {
                        height[r][c] = 1 + height[r - 1][c];
                    } else {
                        height[r][c] = 0;
                    }
                }
            }
        }

        // Optional: print height matrix (debug)
        /*
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(height[r][c] + "\t");
            }
            System.out.println();
        }
        */

        int res = 0;
        for (int r = 0; r < rows; r++) {
            int[] prevSmaller = getPrevSmaller(height[r]);
            int[] nextSmaller = getNextSmaller(height[r]);

            for (int c = 0; c < cols; c++) {
                if (height[r][c] > 0) {
                    int prev = prevSmaller[c];
                    int next = nextSmaller[c];

                    int width = next - prev - 1;
                    int area = width * height[r][c];

                    res = Math.max(res, area);
                }
            }
        }

        return res;
    }

    private int[] getPrevSmaller(int[] a) {
        int n = a.length;
        int[] prevSmaller = new int[n];
        Arrays.fill(prevSmaller, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                prevSmaller[i] = st.peek();
            }

            st.push(i);
        }

        return prevSmaller;
    }

    private int[] getNextSmaller(int[] a) {
        int n = a.length;
        int[] nextSmaller = new int[n];
        Arrays.fill(nextSmaller, n);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] > a[i]) {
                int top = st.pop();
                nextSmaller[top] = i;
            }

            st.push(i);
        }

        return nextSmaller;
    }
}