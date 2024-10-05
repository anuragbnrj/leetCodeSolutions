class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int r = 0; r < numRows; r++) {
            List<Integer> currRow = new ArrayList<>();

            for (int c = 0; c <= r; c++) {
                if (c == 0 || c == r) {
                    currRow.add(1);
                } else {
                    currRow.add(ans.get(r - 1).get(c - 1) + ans.get(r - 1).get(c));
                }
            }
            ans.add(currRow);
        }

        return ans;
    }
}