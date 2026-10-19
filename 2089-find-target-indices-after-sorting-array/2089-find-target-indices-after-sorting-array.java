class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int size = nums.length;

        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < size; i++) {
            if (nums[i] > target) break;

            if (nums[i] == target) ans.add(i);
        }

        return ans;
    }
}