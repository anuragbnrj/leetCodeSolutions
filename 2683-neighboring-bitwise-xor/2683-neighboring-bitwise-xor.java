class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int len = derived.length;

        int xrr = 0;
        for (int i = 0; i < len; i++) {
            xrr = xrr ^ derived[i];
        }

        if (xrr == 0) {
            return true;
        }
        return false;
    }
}