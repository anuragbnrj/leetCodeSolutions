class Solution {
    public int minimumIndex(List<Integer> nums) {
        int len = nums.size();

        Map<Integer, Integer> revFreq = new HashMap<>();
        for (int i = len - 1; i >= 0; i--) {
            int curr = nums.get(i);

            revFreq.put(curr, revFreq.getOrDefault(curr, 0) + 1);
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int splitIdx = -1;
        for (int i = 0; i < len - 1 && splitIdx == -1; i++) {
            int curr = nums.get(i);

            int freq2 = revFreq.get(curr) - 1;
            revFreq.put(curr, freq2);

            int freq1 = freq.getOrDefault(curr, 0) + 1;
            freq.put(curr, freq1);

            if ((freq1 * 2) > (i + 1) && (freq2 * 2) > (len - i - 1)) {
                splitIdx = i;
            }
        }

        return splitIdx;
    }
}