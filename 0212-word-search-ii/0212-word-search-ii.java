class Solution {
    private int rows;
    private int cols;
    private char[][] board;
    private Node root = new Node('\0');

    public List<String> findWords(char[][] board, String[] words) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;

        for (String word : words) {
            root.addWord(word);
        }

        List<String> result = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++){
                dfs(result, row, col, new int[rows][cols], root, new StringBuilder());
            }
        }
        return result;
    }

    private void dfs(List<String> result, int row, int col, int[][] visited, Node curr, StringBuilder word) {
        if (row < 0 || col < 0 || row >= rows || col >= cols ||
            visited[row][col] != 0 || curr.children[board[row][col] - 'a'] == null || 
            curr.children[board[row][col] - 'a'].ref == 0) {
                return;
        }
        
        char c = board[row][col];
        curr = curr.children[c - 'a'];
        word.append(c);
        visited[row][col] = 1;

        if (curr.isWord) {
            result.add(word.toString());
            root.removeWord(word.toString());
        }

        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        for (int[] direction : directions) {
            dfs(result, row + direction[0], col + direction[1], visited, curr, word);
        }
        
        visited[row][col] = 0;
        word.deleteCharAt(word.length() - 1);
    }
}

class Node {
    char val;
    Node[] children;
    boolean isWord;
    int ref;

    public Node(char val) {
        this.val = val;
        this.children = new Node[26];
        this.isWord = false;
        this.ref = 0;
    }

    public void addWord(String word) {
        Node curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
            curr.ref++;
        }
        curr.isWord = true;
    }

    public void removeWord(String word){
        Node curr = this;
        for (char c : word.toCharArray()) {
            curr = curr.children[c - 'a'];
            curr.ref--;
        }
        curr.isWord = false;
    }
}
    