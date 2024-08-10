class Solution {
    Node root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();

        for (String word : words) {
            insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;
        Set<String> result = new HashSet<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean[][] visited = new boolean[rows][cols];
                solve(r, c, board, visited, result, root, "");
            }
        }

        return new ArrayList<>(result);
    }

    private void solve(int r, int c, char[][] board, boolean[][] visited, Set<String> result, Node curr, String currWord) {
        visited[r][c] = true;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        char ch = board[r][c];
        if (curr.child[ch - 'a'] == null) {
            visited[r][c] = false;
            return;
        }
        
        if (curr.child[ch - 'a'].endsAt == true) {
            result.add(currWord + ch);
        }
        
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(nr, nc, rows, cols) && !visited[nr][nc]) {
                solve(nr, nc, board, visited, result, curr.child[ch - 'a'], currWord + ch);
            }
        }

        visited[r][c] = false;
    }

    private boolean isValid(int nr, int nc, int rows, int cols) {
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
            return false;
        }

        return true;
    }

    private void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new Node();
            }

            curr = curr.child[ch - 'a'];
        }

        curr.endsAt = true;
    }

    class Node {
        Node[] child;
        boolean endsAt;

        public Node() {
            child = new Node[26];
            endsAt = false;
        }
    }
}