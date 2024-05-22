class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();;

        List<String> curr = new ArrayList<>();
        solve(0, s, curr, res);
        return res;
    }

    private void solve(int beg, String s, List<String> curr, List<List<String>> res) {
        int n = s.length();

        if (beg == n) {
            if (curr.size() > 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        String temp = "";
        for (int i = beg; i < n; i++) {
            temp += s.charAt(i);

            if (isPalindrome(temp)) {
                curr.add(temp);
                solve(i + 1, s, curr, res);
                curr.remove(curr.size() - 1);
            }
        }

        return;
    }

    private boolean isPalindrome(String s) {
        int n = s.length();

        for (int beg = 0, end = n - 1; beg <= end; beg++, end--) {
            if (s.charAt(beg) != s.charAt(end)) {
                return false;
            }
        }

        return true;
    }

}
