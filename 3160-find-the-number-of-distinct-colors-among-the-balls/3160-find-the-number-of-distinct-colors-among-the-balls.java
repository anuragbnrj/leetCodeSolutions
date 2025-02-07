class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] color = new int[limit + 1];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int newColor = queries[i][1];
            int currColor = color[idx];

            if (currColor != 0) {
                int count = freq.get(currColor);
                if (count == 1) {
                    freq.remove(currColor);
                } else {
                    freq.put(currColor, count - 1);
                }
            }
            freq.put(newColor, freq.getOrDefault(newColor, 0) + 1);
            color[idx] = newColor;

            ans[i] = freq.size();
        }

        return ans;
    }
}
