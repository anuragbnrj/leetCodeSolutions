class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);

        Set<Long> distinct = new HashSet<>();
        distinct.add((long) nums[0] - k);
        long lastTaken = nums[0] - k;
        for (int i = 1; i < len; i++) {
            System.out.println("lastTaken: " + lastTaken);
            long nextToTake = lastTaken + 1;
            long curr = nums[i];

            long toBeAdded;
            if (curr - k <= nextToTake && nextToTake <= curr + k) {
                toBeAdded = nextToTake;
            } else {
                if (curr + k < nextToTake) continue;
                toBeAdded = curr - k;
            }
            distinct.add(toBeAdded);
            lastTaken = toBeAdded;
        }

        System.out.println(distinct.toString());
        return distinct.size();
    }
}