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
        if (node == null) return null;

        Map<Integer, Node> nodeMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        Node cloneHead = new Node(node.val);
        nodeMap.put(cloneHead.val, cloneHead);

        while (!q.isEmpty()) {
            Node front = q.poll();
            Node clonedNode = nodeMap.get(front.val);

            for (Node neighbor : front.neighbors) {
                if (!nodeMap.containsKey(neighbor.val)) {
                    Node clonedNeighbor = new Node(neighbor.val);
                    nodeMap.put(clonedNeighbor.val, clonedNeighbor);
                    q.add(neighbor);
                }
                clonedNode.neighbors.add(nodeMap.get(neighbor.val));
            }
        }
        
        return cloneHead;     
    }

}
