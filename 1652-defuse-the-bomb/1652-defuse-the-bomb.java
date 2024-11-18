class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (k == 0) {
                ans[i] = 0;
            } else {
                int sum = 0;
                for (int j = 1; j <= Math.abs(k); j++) {
                    if (k > 0) {
                        sum += code[(i + j) % len];
                    } else {
                        sum += code[(((i - j) % len) + len) % len];
                    }
                }
                ans[i] = sum;
            }
        }

        return ans;
    }
}