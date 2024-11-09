class Solution {
    public long minEnd(int n, int x) {
        long numA = x;
        long numB = n - 1;
        int bitA = 0;

        while(numB > 0) {
            if (((numA >> bitA) & 1) == 1) {
                bitA += 1;
            } else {
                numA = numA | ((numB & 1) << bitA);
                numB = numB >> 1;
                bitA += 1;
            }
        }

        return numA;
    }
}