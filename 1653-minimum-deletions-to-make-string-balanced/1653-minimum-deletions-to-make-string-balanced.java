class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        char[] sarr = s.toCharArray();

        int[] as = new int[n + 2];
        int[] bs = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            char ch = sarr[i - 1];

            if (ch == 'b') {
                bs[i] = bs[i - 1] + 1;
            } else {
                bs[i] = bs[i - 1];
            }
        }

        int acount = 0;
        for (int i = n; i >= 1; i--) {
            char ch = sarr[i - 1];

            if (ch == 'a') {
                as[i] = as[i + 1] + 1;
            } else {
                as[i] = as[i + 1];
            }
        }

        int ans = 0;
        int bdeleted = 0;
        for (int i = 1; i <= n; i++) {
            char ch = sarr[i - 1];

            if (ch == 'a') {
                if (as[i] < (bs[i] - bdeleted)) {
                    ans += 1;
                    System.out.println("a i: " + i);
                }
            }

            if (ch == 'b') {
                if (bs[i] <= as[i]) {
                    ans += 1;
                    bdeleted += 1;
                    System.out.println("b i: " + i);
                }
            }
        }

        return ans;
    }
}