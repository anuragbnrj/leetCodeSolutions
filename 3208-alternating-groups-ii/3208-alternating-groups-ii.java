class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len = colors.length;
        int[] colorsRec = new int[len * 2];
        for (int i = 0; i < len * 2; i++) {
            if (i < len) {
                colorsRec[i] = colors[i];
            } else {
                colorsRec[i] = colorsRec[i - len];
            }
        }

        int ans = 0;
        Set<Pair<Integer, Integer>> conflictingPairs = new HashSet<>();
        for (int left = 0, right = 1; right < (len + k - 1); right++) {
            int currColor = colorsRec[right];
            int prevColor = colorsRec[right - 1];

            if (currColor == prevColor) {
                conflictingPairs.add(new Pair(right - 1, right));
            }

            if ((right - left + 1) == k && conflictingPairs.size() == 0) {
                ans += 1;
                // System.out.println("left: " + left + ", right: " + right);
            }

            if (right - left + 1 == k) {
                int leftColor = colorsRec[left];
                int leftSuccessorColor = colorsRec[left + 1];

                if (leftColor == leftSuccessorColor) {
                    conflictingPairs.remove(new Pair(left, left + 1));
                }

                left += 1;
            }
        }

        return ans;
    }
}