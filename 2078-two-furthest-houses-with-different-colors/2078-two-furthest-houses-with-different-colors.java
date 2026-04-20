class Solution {
    public int maxDistance(int[] colors) {
        int size = colors.length;

        int ans = 0;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                if (colors[i] != colors[j]) {
                    ans = Math.max(ans, j - i);
                    break;
                }
            }
        }
        
        return ans;
    }
}