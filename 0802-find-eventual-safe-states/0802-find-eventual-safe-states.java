class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        int[] isSafe = new int[nodes];
        // 0 - don't know
        // 1 - safe
        // -1 - part of cycle

        for (int node = 0; node < nodes; node++) {
            if (graph[node] == null || graph[node].length == 0) {
                isSafe[node] = 1;
            }
        }

        for (int node = 0; node < nodes; node++) {
            if (isSafe[node] == 0) {
                Set<Integer> visited = new HashSet<>();
                checkForNode(node, isSafe, graph, visited, -1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int node = 0; node < nodes; node++) {
            if (isSafe[node] == 1) {
                ans.add(node);
            }
        }
        return ans;
    }

    private boolean checkForNode(int node, int[] isSafe, int[][] graph, Set<Integer> visited, int parent) {
        if (isSafe[node] == -1) {
            return false;
        }

        if (isSafe[node] == 1) {
            return true;
        }
        
        visited.add(node);
        for (int neigh : graph[node]) {
            if (neigh == parent) continue;

            if (visited.contains(neigh) || !checkForNode(neigh, isSafe, graph, visited, node)) {
                isSafe[node] = -1;
                visited.remove(node);
                return false;
            } 
        }

        visited.remove(node);
        isSafe[node] = 1;
        return true;
    }
}