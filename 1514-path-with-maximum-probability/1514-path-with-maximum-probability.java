class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        int INF = (int) 1e9;
        double[] totProb = new double[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            totProb[i] = -INF;
        }

        List<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            graph[u].add(new Pair(prob, v));
            graph[v].add(new Pair(prob, u));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.prob, a.prob);
        });

        totProb[start_node] = 1;
        pq.offer(new Pair(1.0, start_node));

        while (!pq.isEmpty()) {
            Pair top = pq.peek();
            pq.poll();

            double currProb = top.prob;
            int currNode = top.node;

            if (visited[currNode]) continue;
            visited[currNode] = true;

            List<Pair> neighbours = graph[currNode];
            for (Pair edge : neighbours) {
                double prob = edge.prob;
                int nextNode = edge.node;

                if (totProb[nextNode] < currProb * prob) {
                    totProb[nextNode] = currProb * prob;
                    pq.offer(new Pair(totProb[nextNode], nextNode));
                }
            }
        }

        if (totProb[end_node] <= -INF) {
            return 0;
        }
        return totProb[end_node];
    }

    class Pair{
        double prob;
        int node;

        public Pair(double p, int n) {
            this.prob = p;
            this.node = n;
        }
    }
}