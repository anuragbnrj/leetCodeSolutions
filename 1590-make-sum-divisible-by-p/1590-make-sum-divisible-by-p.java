class Solution {
    public int minSubarray(int[] nums, int p) {
        long totSum = 0;
        long mod = 0;
        for (int num : nums) {
            totSum += num; 
        }
        mod = totSum % p;
        // System.out.println("mod: " + mod);
        if (mod == 0) return 0;

        Map<Long, Integer> lastModPos = new HashMap<>();
        lastModPos.put(0L, -1);
        long currSum = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            long currMod = currSum % p;
            // System.out.println("currMod: " + currMod);
            long req = (((currMod - mod) % p) + p) % p;
            // System.out.println("req: " + req);

            if (lastModPos.containsKey(req)) {
                ans = Math.min(ans, i - lastModPos.get(req));
            }

            lastModPos.put(currMod, i);
            // System.out.println("==============================");
        }

        return ans == Integer.MAX_VALUE || ans == nums.length ? -1 : ans;
    }
}