class Solution {
    public int[] sumPrefixScores(String[] words) {
        Node root = new Node();
        for (String word : words) {
            insert(word, root);
        }

        int len = words.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = getScore(words[i], root);
        }

        return ans;
    }

    private int getScore(String word, Node root) {
        Node curr = root;
        int score = 0;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.childNodes[idx] == null) {
                break;
            } else {
                curr = curr.childNodes[idx];
                score += curr.prefixOf;
            }
        }

        return score;
    }

    private void insert(String word, Node root) {
        Node curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.childNodes[idx] == null) {
                curr.childNodes[idx] = new Node();
            }

            curr = curr.childNodes[idx];
            curr.prefixOf += 1;
        }

        curr.endsAt += 1;
    }

    class Node {
        Node[] childNodes;
        int prefixOf;
        int endsAt;

        public Node() {
            childNodes = new Node[26];
            prefixOf = 0;
            endsAt = 0;
        }
    }
}