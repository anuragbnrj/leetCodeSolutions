class Solution {
    public boolean checkIfExist(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int a = arr[i];
            for (int j = 0; j < len; j++) {
                if (i == j) continue;

                int b = arr[j];

                if (a == (2 * b)) return true;
            }
        }

        return false;
    }
}