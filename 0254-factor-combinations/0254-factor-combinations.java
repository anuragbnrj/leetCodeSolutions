class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), n, 2, ans);
        return ans;
    }

    private void backtrack(List<Integer> current, int n, int start, List<List<Integer>> ans) {
        if (n == 1 && current.size() > 1) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                current.add(i);
                backtrack(current, n / i, i, ans);
                current.remove(current.size() - 1);
            }
        }
    }
}