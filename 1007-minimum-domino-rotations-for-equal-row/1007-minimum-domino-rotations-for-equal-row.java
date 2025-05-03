class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int len = tops.length;
        int[] topCount = new int[7];
        int[] bottomCount = new int[7];
        int[] commonCount = new int[7];

        for (int i = 0; i < len; i++) {
            topCount[tops[i]] += 1;
            bottomCount[bottoms[i]] += 1;

            if (tops[i] == bottoms[i]) {
                commonCount[tops[i]] += 1;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            if ((topCount[i] + bottomCount[i] - commonCount[i]) == len) {
                ans = Math.min(ans, Math.min(topCount[i], bottomCount[i]) - commonCount[i]);
            }
        }
        // System.out.println(Arrays.toString(topCount));
        // System.out.println(Arrays.toString(bottomCount));

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }
}