class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, dash = 0;
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);

            if (ch == 'L') {
                l += 1;
            } else if (ch == 'R') {
                r += 1;
            } else {
                dash += 1;
            }
        }

        return Math.max(l + dash - r, r + dash - l);
    }
}