class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for (int i = 1; i < n; i++) {
            if (!containsZero(i) && !containsZero(n - i)) {
                ans[0] = i;
                ans[1] = n - i;
                break;
            }
        }
        
        return ans;
    }

    private boolean containsZero(int n) {
        while (n > 0) {
            int r = n % 10;

            if (r == 0) {
                return true;
            }

            n /= 10;
        }

        return false;
    } 
}