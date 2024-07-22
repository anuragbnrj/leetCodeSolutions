class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        Pair[] together = new Pair[n];
        for (int i = 0; i < n; i++) {
            together[i] = new Pair(names[i], heights[i]);
        }

        Arrays.sort(together, (x, y) -> {
            return Integer.compare(x.height, y.height);
        });

        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = together[n - 1 - i].name;
        }

        return ans;
    }

    static class Pair {
        String name;
        int height;

        public Pair(String n, int h) {
            this.name = n;
            this.height = h;
        }
    }
}