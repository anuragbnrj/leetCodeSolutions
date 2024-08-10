class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();        
    }
    
    public void addWord(String word) {
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
        boolean ans = solve(word, 0, curr);

        return ans;
    }

    public boolean solve(String word, int idx, Node curr) {
        if (idx == word.length() - 1) {
            char ch = word.charAt(idx);

            if (ch == '.') {
                for (int i = 0; i < 26; i++) {
                    if (curr.child[i] != null && curr.child[i].endsCount > 0) {
                        return true;
                    }
                }
            } else {
                if (curr.child[ch -'a'].endsCount > 0) {
                    return true;
                }
            }

            return false;
        }

        char ch = word.charAt(idx);
        boolean result = false;
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (curr.child[i] != null) {
                    result = result || solve(word, idx + 1, curr.child[i]);
                }
            }
        } else {
            if (curr.child[ch - 'a'] == null) {
                return false;
            }
            result = solve(word, idx + 1, curr.child[ch - 'a']);
        }

        return result;
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
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */