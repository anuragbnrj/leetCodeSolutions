class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        long maxLen = 0;
        long maxArea = 0;

        for (int[] dimension : dimensions) {
            long length = dimension[0];
            long width = dimension[1];

            long diagLen = length * length + width * width;

            if (diagLen > maxLen) {
                maxLen = diagLen;
                maxArea = length * width;
            } else if (diagLen == maxLen) {
                if (length * width > maxArea) {
                    maxLen = diagLen;
                    maxArea = length * width;
                }
            }
        }

        return (int) maxArea;        
    }
}