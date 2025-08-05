class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int len = fruits.length;
        
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int qty = fruits[i];
            boolean placed = false;
            for (int j = 0; j < baskets.length && !placed; j++) {
                if (baskets[j] >= qty) {
                    placed = true;
                    baskets[j] = -1;
                }
            }

            if (!placed) ans += 1; 
        }

        return ans;
    }
}