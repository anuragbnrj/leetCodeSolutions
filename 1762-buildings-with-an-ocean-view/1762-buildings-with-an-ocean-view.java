class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> ansList = new ArrayList<>();

        int maxTillNow = -1;
        for (int i = heights.length - 1; i >= 0; i--) {
            int curr = heights[i];

            if (curr > maxTillNow) {
                ansList.add(i);
            }

            maxTillNow = Math.max(maxTillNow, curr);
        }
        
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[ansList.size() - 1 - i] = ansList.get(i);
        }

        return ans;
    }
}