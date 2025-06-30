class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int currFreq = freq.getOrDefault(curr, 0);
            freq.put(curr, currFreq + 1);
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (freq.containsKey(key - 1)) {
                ans = Math.max(ans, val + freq.get(key - 1));
            }
        }

        return ans;
    }
}