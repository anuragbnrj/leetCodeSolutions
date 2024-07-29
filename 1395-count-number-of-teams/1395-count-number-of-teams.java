class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;

        int[] greater = new int[n];
        int[] lesser = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int curr = rating[i];
            int lt = 0;
            int gt = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (rating[j] < curr) {
                    lt += 1;
                }

                if (rating[j] > curr) {
                    gt += 1;
                }
            }

            lesser[i] = lt;
            greater[i] = gt;
        }

        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = rating[i];
            for (int j = i - 1; j >= 0; j--) {
                if (rating[j] < curr) {
                    ans += lesser[j];
                }

                if (rating[j] > curr) {
                    ans += greater[j];
                }
            }
        }

        return ans;
    }
}