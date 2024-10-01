class Solution {
    public boolean canArrange(int[] arr, int k) {
        int len = arr.length;

        int[] modArr = new int[k];
        for (int i = 0; i < len; i++) {
            int rem = ((arr[i] % k) + k) % k;
            modArr[rem] += 1;
        }

        if (modArr[0] % 2 == 1) {
            return false;
        }
        int i = 1;
        for (; i < ((k + 1) / 2); i++) {
            if (modArr[i] != modArr[k - i]) {
                return false;
            }
        }
        if ((k % 2 == 0) && (modArr[k / 2] % 2 == 1)) {
            return false;
        }

        return true;
    }
}