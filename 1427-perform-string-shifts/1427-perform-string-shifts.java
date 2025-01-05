class Solution {
    public String stringShift(String s, int[][] shift) {
        int len = s.length();
        int totalShift = 0;
        for (int[] shft : shift) {
            int dir = shft[0];
            int amt = shft[1];

            if (dir == 0) {
                totalShift -= amt;
            } else {
                totalShift += amt;
            }
        }

        

        char[] sarr = s.toCharArray();
        totalShift = ((totalShift % len) + len) % len;
        if (totalShift > 0) {
            reverse(0, totalShift, sarr);
            reverse(totalShift + 1, len - 1, sarr);
            reverse(0, len - 1, sarr);
        }

        return new String(sarr);
    }

    private void reverse(int beg, int end, char[] sarr) {
        while (beg < end) {
            char temp = sarr[beg];
            sarr[beg] = sarr[end];
            sarr[end] = temp;

            beg++;
            end--;
        }
    }
}