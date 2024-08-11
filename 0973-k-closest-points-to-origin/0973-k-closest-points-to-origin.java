class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> {
            return a.dist - b.dist;
        });
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int dist = x * x + y * y;
            pq.add(new Point(dist, x, y));
        }

        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = new int[2];

            Point top = pq.poll();
            res[i][0] = top.x;
            res[i][1] = top.y;
        }

        return res;
    }

    class Point {
        int dist;
        int x;
        int y;

        public Point(int _d, int _x, int _y) {
            this.dist = _d;
            this.x = _x;
            this.y = _y;
        }
    }
}