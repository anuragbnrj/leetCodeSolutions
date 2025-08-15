class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;

        int countOfOnes = 0;
        while (n > 0) {
            int r = n % 4;
            
            if (r > 1) return false;

            if (r == 1) countOfOnes += 1;

            n /= 4;
        }

        return countOfOnes == 1;
    }
}