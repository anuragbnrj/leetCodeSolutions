/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int rows, int cols, ListNode head) {
        int currRow = 0;
        int currCol = 0;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int direction = 0;

        ListNode currNode = head;
        int[][] ans = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows * cols; i++) {
            int val = -1;
            if (currNode != null) {
                val = currNode.val;
                currNode = currNode.next;
            }

            ans[currRow][currCol] = val;
            visited[currRow][currCol] = true;

            int nr = currRow + dr[direction];
            int nc = currCol + dc[direction];

            if (!isValid(nr, nc, rows, cols) || visited[nr][nc] == true) {
                direction = (direction + 1) % 4;
                nr = currRow + dr[direction];
                nc = currCol + dc[direction];
            }

            currRow = nr;
            currCol = nc;
        }

        return ans;
    }

    private boolean isValid(int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return false;
        }

        return true;
    }
}