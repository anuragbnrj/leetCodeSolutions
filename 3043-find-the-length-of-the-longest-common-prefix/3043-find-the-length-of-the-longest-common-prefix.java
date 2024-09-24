class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Node root = new Node();

        for (int num : arr1) {
            String numStr = Integer.toString(num);
            addToTrie(numStr, root);
        }

        int ans = 0;
        for (int num : arr2) {
            String numStr = Integer.toString(num);

            int longestCommonPrefixLength = getLongestCommonPrefixLength(numStr, root);
            ans = Math.max(ans, longestCommonPrefixLength);
        }

        return ans;
    }

    private int getLongestCommonPrefixLength(String numStr, Node root) {
        Node curr = root;

        int commonLength = 0;
        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';

            if (curr.children[idx] != null) {
                curr = curr.children[idx];
                commonLength += 1;
            }
        }

        return commonLength;
    }

    private void addToTrie(String numStr, Node root) {
        Node curr = root;

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }
    }

    class Node {
        Node[] children;

        public Node() {
            children = new Node[10];
        }
    }
}