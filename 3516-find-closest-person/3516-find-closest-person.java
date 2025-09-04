class Solution {
    public int findClosest(int x, int y, int z) {
        int dist1 = Math.abs(x - z);
        int dist2 = Math.abs(y - z);

        int ans = 0;
        if (dist1 < dist2) {
            ans = 1;
        } else if (dist1 > dist2) {
            ans = 2;
        }

        return ans;
    }
}