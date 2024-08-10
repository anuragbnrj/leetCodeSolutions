class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new Node();
            }

            curr = curr.child[ch - 'a'];
        }

        curr.endsCount += 1;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.child[ch - 'a'] == null) {
                return false;
            }

            curr = curr.child[ch - 'a'];
        }

        if (curr.endsCount >= 1) {
            return true;
        }

        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char ch : prefix.toCharArray()) {
            if (curr.child[ch - 'a'] == null) {
                return false;
            }

            curr = curr.child[ch - 'a'];
        }

        return true;
    }

    class Node {
        Node[] child;
        int endsCount;

        public Node() {
            child = new Node[26];
            endsCount = 0;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */