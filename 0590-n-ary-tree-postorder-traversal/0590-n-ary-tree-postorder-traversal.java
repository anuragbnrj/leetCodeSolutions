/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();

        solvePostOrder(root, ans);

        return ans;
    }

    private void solvePostOrder(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            solvePostOrder(children.get(i), ans);
        }

        ans.add(root.val);
    }
}