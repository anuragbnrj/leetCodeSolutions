class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int beg = 0, end = (int) 1e9;
        while (beg < end) {
            int mid = beg + ((end - beg) / 2);
            // System.out.println("mid: " + mid);

            if (!possible(nums, p, mid)) beg = mid + 1;
            else end = mid;
        }
        
        return beg;
    }

    private boolean possible(int[] nums, int p, int diff) {
        int len = nums.length;
        Set<Integer> skipped = new HashSet<>();

        for (int i = 0; i < len - 1; i++) {
            if (skipped.contains(i)) continue;

            int curr = nums[i];
            int next = nums[i + 1];

            int absDiff = Math.abs(curr - next);

            if (absDiff <= diff) {
                skipped.add(i);
                skipped.add(i + 1);
            }
        }

        int possiblePairs = skipped.size() / 2;

        if (possiblePairs >= p) {
            return true;
        }
        return false;
    }
}