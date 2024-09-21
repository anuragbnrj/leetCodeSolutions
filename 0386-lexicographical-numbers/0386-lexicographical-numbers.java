class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        solve(0, n, ans);
        return ans;
    }

    private void solve(int curr, int n, List<Integer> ans) {
        if (curr > n) {
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if ((curr + i) != 0 && (curr + i) <= n) {
                ans.add(curr + i);
                solve((curr + i) * 10, n, ans);
            }
            
            
        }
    }
}