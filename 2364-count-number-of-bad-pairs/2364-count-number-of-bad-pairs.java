class Solution {
    public long countBadPairs(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        long notBadPairs = 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i];

            int diff = num - i;
            int currCount = freq.getOrDefault(diff, 0);
            notBadPairs += currCount;
            freq.put(diff, currCount + 1);
        }

        long totalPairs = (len * (len - 1)) / 2;

        return totalPairs - notBadPairs;
    }
}