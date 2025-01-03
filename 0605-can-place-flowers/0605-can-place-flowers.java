class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (canPlace(i, flowerbed)) {
                n--;
                flowerbed[i] = 1;
            }
        }

        if (n <= 0) {
            return true;
        }
        return false;
    }

    private boolean canPlace(int idx, int[] flowerbed) {
        if (flowerbed[idx] != 0) return false;

        if (idx - 1 >= 0 && flowerbed[idx - 1] != 0) return false;

        if (idx + 1 < flowerbed.length && flowerbed[idx + 1] != 0) return false;

        return true;
    }
}