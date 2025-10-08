class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int len = spells.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            long spell = spells[i];

            int beg = 0;
            int end = potions.length;
            while (beg < end) {
                int mid = beg + (end - beg) / 2;

                if (((long) potions[mid] * spell) < success) {
                    beg = mid + 1;
                } else {
                    end = mid;
                }
            }

            ans[i] = potions.length - beg;
        }

        return ans;
    }
}