class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int len = bottomLeft.length;

        long ans = 0;
        for (int i = 0; i < len; i++) {
            int curr_x_low = bottomLeft[i][0];
            int curr_x_high = topRight[i][0];

            int curr_y_low = bottomLeft[i][1];
            int curr_y_high = topRight[i][1];

            for (int j = i + 1; j < len; j++) {
                int next_x_low = bottomLeft[j][0];
                int next_x_high = topRight[j][0];

                int next_y_low = bottomLeft[j][1];
                int next_y_high = topRight[j][1];

                int x_overlap = Math.max(0, Math.min(curr_x_high, next_x_high) - Math.max(curr_x_low, next_x_low));
                int y_overlap = Math.max(0, Math.min(curr_y_high, next_y_high) - Math.max(curr_y_low, next_y_low));

                int side_length = Math.min(x_overlap, y_overlap); 
                ans = Math.max(ans, 1L * side_length * side_length);
            }
        }

        return ans;
    }
}