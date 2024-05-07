class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;

        int res = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (mpp.get(curr) == null) {
                mpp.put(curr, 1);
            } else {
                res += mpp.get(curr);
                mpp.put(curr, mpp.get(curr) + 1);
            }
        }

        return res;
    }
}