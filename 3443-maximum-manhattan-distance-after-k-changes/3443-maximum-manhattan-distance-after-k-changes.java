class Solution {
    public int maxDistance(String str, int kImm) {
        int n = 0, s = 0, e = 0, w = 0;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            // System.out.println("i: " + i + ", kImm: " + kImm);
            char ch = str.charAt(i);
            if (ch == 'N') {
                n += 1;
            } else if (ch == 'S') {
                s += 1;
            } else if (ch == 'E') {
                e += 1;
            } else {
                w += 1;
            }

            int maxX = Math.max(e, w);
            int minX = Math.min(e, w);
            int maxY = Math.max(n, s);
            int minY = Math.min(n, s);
            int k = kImm;

            // System.out.println("Before- minX: " + minX + ", maxX: " + maxX + ", minY: " + minY + ", maxY: " + maxY);

            if (minX > k) {
                minX -= k;
                maxX += k;
                k = 0;
            } else {
                k -= minX;
                maxX += minX;
                minX = 0;
            }

            if (minY > k) {
                minY -= k;
                maxY += k;
                k = 0;
            } else {
                k -= minY;
                maxY += minY;
                minY = 0;
            }

            // System.out.println("After- minX: " + minX + ", maxX: " + maxX + ", minY: " + minY + ", maxY: " + maxY);
            // System.out.println("ans: " +  (maxX - minX + maxY - minY));
            // System.out.println();
            ans = Math.max(ans, maxX - minX + maxY - minY);
        }

        return ans;
    }
}