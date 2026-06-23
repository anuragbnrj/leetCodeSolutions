/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Node parent = new Node(-1);

        return dfs(node, parent, new HashMap<>());
    }

    private Node dfs(Node curr, Node parent, Map<Integer, Node> nodeMap) {
        if (curr == null) return null;

        Node currCopy = new Node(curr.val);
        nodeMap.put(curr.val, currCopy);        
        for (Node neigh : curr.neighbors) {
            if (!nodeMap.containsKey(neigh.val)) {
                Node neighCopy = dfs(neigh, curr, nodeMap);
                currCopy.neighbors.add(neighCopy);
            } else {
                currCopy.neighbors.add(nodeMap.get(neigh.val));
            }
        }

        return currCopy;
    }
}