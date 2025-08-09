class Solution {
    public boolean isPowerOfTwo(int n) {
        int setBits = Long.bitCount(n);

        return (setBits == 1);
    }
}