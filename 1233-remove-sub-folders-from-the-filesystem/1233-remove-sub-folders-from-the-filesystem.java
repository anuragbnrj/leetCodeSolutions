class Solution {
    public List<String> removeSubfolders(String[] paths) {
        Node root = new Node();
        for (String path : paths) {
            addPath(path, root);
        }

        List<String> ans = new ArrayList<>();
        for (String path : paths) {
            if (!isSubFolder(path, root)) {
                ans.add(path);
            }
        }
        return ans;
    }

    private boolean isSubFolder(String path, Node root) {
        String[] folders = path.split("/");

        Node curr = root;
        for (String folder : folders) {
            if (curr.endsAt == true) {
                return true;
            }

            curr = curr.childNodes.get(folder);
        }

        return false;
    }

    private void addPath(String path, Node root) {
        String[] folders = path.split("/");

        Node curr = root;
        for (String folder : folders) {
            Node temp = curr.childNodes.getOrDefault(folder, new Node());
            curr.childNodes.put(folder, temp);

            curr = curr.childNodes.get(folder);
        }

        curr.endsAt = true;
    }

    class Node {
        Map<String, Node> childNodes;
        boolean endsAt;

        public Node() {
            childNodes = new HashMap<>();
            endsAt = false;
        }
    }
}