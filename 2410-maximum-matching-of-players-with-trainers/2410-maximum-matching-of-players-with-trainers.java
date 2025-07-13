class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int plen = players.length;
        int tlen = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0;
        int ans = 0;
        while (i < plen && j < tlen) {
            if (players[i] <= trainers[j]) {
                ans += 1;
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }

        return ans;
    }
}