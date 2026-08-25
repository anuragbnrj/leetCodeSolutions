class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> multiple = new HashSet<>();

        for (int num: nums) {
            if (num % k == 0) {
                multiple.add(num / k);
            }
        }

        int missing = nums.length + 1;
        for (int i = 1; i < nums.length + 1; i++) {
            if (!multiple.contains(i)) {
                missing = i;
                break;
            }
        }
        
        return k * missing;
    }
}