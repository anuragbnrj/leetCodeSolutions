class Solution {
    public int largestAltitude(int[] gain) {
        int currAlt = 0;

        int ans = 0;
        for (int height : gain) {
            currAlt += height;

            ans = Math.max(ans, currAlt);
        }
        
        return ans;
    }
}