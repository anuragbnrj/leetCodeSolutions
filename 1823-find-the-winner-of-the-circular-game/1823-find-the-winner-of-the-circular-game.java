class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] eliminated = new boolean[n];

        int present = n;
        int curr = -1;
        while (present > 1) {
            int ctr = 0;
            while (ctr < k) {
                curr = (curr + 1) % n;

                if (eliminated[curr] == false) {
                    ctr++;
                }
            }

            eliminated[curr] = true;
            present -= 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (eliminated[i] == false) {
                ans = i;
            }
        }

        return (ans + 1);
    }
}