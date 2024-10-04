class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int req = target - nums[i];

            if (idxMap.containsKey(req)) {
                return new int[]{idxMap.get(req), i};
            }

            idxMap.put(nums[i], i);
        }

        return new int[0];
    }
}
