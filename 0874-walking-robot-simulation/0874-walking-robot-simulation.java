class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int olen = obstacles.length;
        HashSet<Point> obs = new HashSet<>();
        for (int i = 0; i < olen; i++) {
            obs.add(new Point(obstacles[i][0], obstacles[i][1]));
        }

        int clen = commands.length;
        int currDir = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int currx = 0;
        int curry = 0;

        int ans = 0;
        for (int i = 0; i < clen; i++) {
            int command = commands[i];

            if (command == -1) {
                currDir = (currDir + 1) % 4;
            } else if (command == -2) {
                currDir = ((currDir - 1) % 4 + 4) % 4;
            } else {
                for (int j = 0; j < command; j++) {
                    int nx = currx + dx[currDir];
                    int ny = curry + dy[currDir];

                    Point newPoint = new Point(nx, ny);

                    if (obs.contains(newPoint)) {
                        break;
                    }

                    int dist = nx * nx + ny * ny;

                    // System.out.println("currx: " + currx + ", curry: " + curry + ", nx: " + nx + ", ny: " + ny + ", dist: " + dist);
                    ans = Math.max(ans, dist);

                    currx = nx;
                    curry = ny;
                }
            }
        }   
        
        return ans;
    }

    class Point {
        int x;
        int y;

        public Point(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }

        public int hashCode() {
            return x * 10007 + y;
        }

        public boolean equals(Object another) {
            if (this == another) return true;
            if (!(another instanceof Point)) return false;

            Point otherPoint = (Point) another;

            if (this.x == otherPoint.x && this.y == otherPoint.y) {
                return true;
            }

            return false;
        }
    }
}