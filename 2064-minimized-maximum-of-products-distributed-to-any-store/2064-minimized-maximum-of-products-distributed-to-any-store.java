class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int maxQty = 0;
        for (int qty : quantities) {
            maxQty = Math.max(maxQty, qty);
        }

        int beg = 0;
        int end = maxQty;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            // System.out.println("mid: " + mid + ", result: " + isPossible(mid, n, quantities));

            if (!isPossible(mid, n, quantities)) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }

    private boolean isPossible(int mid, int n, int[] quantitiesConst) {
        int[] quantities = quantitiesConst.clone();

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (quantities[j] == 0) {
                j++;
            }

            if (j >= quantities.length) {
                return true;
            }

            if (quantities[j] >= mid) {
                quantities[j] -= mid;
            } else {
                quantities[j] = 0;
            }
        }

        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] > 0) {
                return false;
            }
        } 

        return true;
    }
}