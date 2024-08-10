class Solution {
    Node root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();

        for (String word : words) {
            insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> result = new HashSet<>();
        StringBuilder currWord = new StringBuilder();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                solve(r, c, board, visited, result, root, currWord);
            }
        }

        return new ArrayList<>(result);
    }

    private void solve(int r, int c, char[][] board, boolean[][] visited, Set<String> result, Node curr, StringBuilder currWord) {
        int rows = board.length;
        int cols = board[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c]) {
            return;
        }

        char ch = board[r][c];
        if (curr.child[ch - 'a'] == null) {
            return;
        }
        
        curr = curr.child[ch - 'a'];
        currWord.append(ch);
        if (curr.endsAt == true) {
            result.add(currWord.toString());
        }
        
        visited[r][c] = true;
        solve(r - 1, c, board, visited, result, curr, currWord);
        solve(r, c - 1, board, visited, result, curr, currWord);
        solve(r, c + 1, board, visited, result, curr, currWord);
        solve(r + 1, c, board, visited, result, curr, currWord);

        visited[r][c] = false;
        currWord.deleteCharAt(currWord.length() - 1);
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