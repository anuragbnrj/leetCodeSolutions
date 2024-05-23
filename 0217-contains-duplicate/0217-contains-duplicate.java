class Solution {
    public boolean containsDuplicate(int[] nums) {
        int N = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int curr = nums[i];

            int count = freq.getOrDefault(curr, 0);

            if (count > 0) {
                return true;
            }

            freq.put(curr, count + 1);
        }

        return false;
    }
}