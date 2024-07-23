class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            int count = freq.getOrDefault(num, 0);
            freq.put(num, count + 1);
        }

        int[] ans = Arrays.stream(nums)
                .boxed()
                .sorted((x, y) -> {
                    int freqCompare = Integer.compare(freq.get(x), freq.get(y));
                    if (freqCompare == 0) {
                        return Integer.compare(y, x);
                    }
                    return freqCompare;
                })
                .mapToInt(i -> i)
                .toArray();

        return ans;
    }
}
