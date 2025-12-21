class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        int ans = 0;
        Set<Integer> sorted = new HashSet<>();
        for (int c = 0; c < cols; c++) {
            Set<Integer> iterSorted = new HashSet<>();
            boolean deleteCol = false;
            for (int r = 1; r < rows; r++) {
                if (sorted.contains(r)) continue;

                char ch1 = strs[r - 1].charAt(c);
                char ch2 = strs[r].charAt(c);

                if (ch1 > ch2) {
                    ans += 1;
                    deleteCol = true;
                    break;
                } else if (ch1 < ch2) {
                    iterSorted.add(r);
                }
            }

            if (deleteCol == false) sorted.addAll(iterSorted);

            if (sorted.size() == rows - 1) break;
        }

        return ans;
    }
}