class Solution {
    public int maximumLength(int[] nums) {
        Arrays.sort(nums);

        Map<Long, Integer> freq = new HashMap<>();
        Set<Long> stt = new LinkedHashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            freq.merge(1L * num, 1, (oldVal, newVal) -> oldVal + newVal);
            stt.add(1L * num);
        }

        Map<Long, Integer> possible = new HashMap<>();
        int ans = 1;
        for (long num : stt) {
            int maxPossible = 1;

            if (num == 1L) {
                maxPossible = freq.get(num) % 2 == 0 ? freq.get(num) - 1 : freq.get(num);
            } else {
                if (freq.get(num) > 1 && possible.getOrDefault(num * num, 0) >= 1) {
                    maxPossible = 2 + possible.get(num * num);
                }

                possible.put(num, maxPossible);
            }

            ans = Math.max(ans, maxPossible);
        }

        return ans;
    }
}