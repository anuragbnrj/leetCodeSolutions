class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;

        boolean startNew = true;
        boolean isPossible = true;
        for (int i = 0; i < len - 1; i++) {
            int bit = bits[i];

            if (startNew == true) {
                if (bit == 0) startNew = true;
                else startNew = false;
            } else {
                startNew = true;
            }
        }

        int lastBit = bits[len - 1];

        if (startNew == false) {
            return false;
        } else {
            return true;
        }
    }
}