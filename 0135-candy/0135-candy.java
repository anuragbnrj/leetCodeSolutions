class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += candies[i];
        }

        return ans;
    }
}