class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adjList.add(new ArrayList<>());
        }

        int len = original.length;
        for (int i = 0; i < len; i++) {
            char curr = original[i];
            char next = changed[i];
            int weight = cost[i];
            adjList.get(curr - 'a').add(new Edge(next, weight));
        }

        len = source.length();
        long ans = 0;
        HashMap<String, Long> cache = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char src = source.charAt(i);
            char des = target.charAt(i);
            if (src == des) continue;

            String key = src + "-" + des;
            if (cache.containsKey(key)) {
                ans += cache.get(key);
                continue;
            }

            long minCostToDes = minCost(src, des, adjList);
            if (minCostToDes == -1) return -1;

            cache.put(key, minCostToDes);

            ans += minCostToDes;
        }

        return ans;
    }

    private long minCost(char src, char des, List<List<Edge>> adjList) {
        long[] minCost = new long[26];
        Arrays.fill(minCost, Long.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return Long.compare(a.cost, b.cost);
        });
        pq.offer(new Edge(src, 0));
        minCost[src - 'a'] = 0;

        while (!pq.isEmpty()) {
            Edge top = pq.poll();
            char currNode = top.node;
            long costToCurr = top.cost;

            if (currNode == des) {
                return costToCurr;
            }

            for (Edge neigh : adjList.get(currNode - 'a')) {
                char nextNode = neigh.node;
                long weight = neigh.cost;

                if (costToCurr + weight < minCost[nextNode - 'a']) {
                    pq.offer(new Edge(nextNode, costToCurr + weight));
                    minCost[nextNode - 'a'] = costToCurr + weight;
                }
            }
        }

        return -1;
    }

    static class Edge {
        char node;
        long cost;

        public Edge(char _node, long _cost) {
            node = _node;
            cost = _cost;
        }
    }
}