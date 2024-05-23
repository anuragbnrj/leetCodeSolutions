class Solution {
    public int[] twoSum(int[] nums, int target) {
        int N = nums.length;

        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int curr = nums[i];
            int compl = target - nums[i];

            if (mpp.containsKey(compl)) {
                int[] arr = {i, mpp.get(compl)};
                return arr;
            }

            mpp.put(curr, i);
        }

        return new int[0];
    }
}