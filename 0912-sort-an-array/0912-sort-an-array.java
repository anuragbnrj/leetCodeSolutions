class Solution {
    public int[] sortArray(int[] nums) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for (int num : nums) {
            int count = freq.getOrDefault(num, 0);
            freq.put(num, count + 1);
        }

        int[] ans = new int[nums.length];
        int i = 0;
        for (Integer key : freq.keySet()) {
            int count = freq.get(key);
            for (int j = 0; j < count; j++) {
                ans[i++] = key;
            }
        }

        return ans;
    }
}