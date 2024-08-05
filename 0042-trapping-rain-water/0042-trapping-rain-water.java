class Solution {

    int INF = (int) 1e9;
    public int trap(int[] height) {
        int n = height.length;
        int[] pge = new int[n];
        int[] nge = new int[n];

        int currMax = -1;
        for (int i = 0; i < n; i++) {
            pge[i] = currMax;
            currMax = Math.max(currMax, height[i]);
        }

        currMax = -1;
        for (int i = n - 1; i >= 0; i--) {
            nge[i] = currMax;
            currMax = Math.max(currMax, height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int prev = pge[i];
            int next = nge[i];

            int mn = Math.min(prev, next);
            if (mn != -1 && (mn - height[i]) > 0) {
                // System.out.println(i + ": " + (mn - height[i]));
                ans += (mn - height[i]); 
            }
        }

        return ans;
    }
}