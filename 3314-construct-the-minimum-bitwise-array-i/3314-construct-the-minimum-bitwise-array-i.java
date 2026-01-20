class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        HashMap<Integer, Integer> orMap = new HashMap<>();
        for (int i = 1; i <= 1000; i++) {
            int orr = i | (i + 1);

            int currVal = orMap.getOrDefault(orr, Integer.MAX_VALUE);

            if (i < currVal) {
                orMap.put(orr, i);
            }
        }

        int len = nums.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int curr = nums.get(i);
            if (orMap.containsKey(curr)) {
                ans[i] = orMap.get(curr);
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }
}