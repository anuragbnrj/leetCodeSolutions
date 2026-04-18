class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int ans = (int) 1e9;

        Map<Integer, Integer> prevLocation = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int mirrorPair = getMirrorPair(num);

            if (prevLocation.containsKey(mirrorPair)) {
                ans = Math.min(ans, prevLocation.get(mirrorPair) - i);
            }

            prevLocation.put(num, i);
        }

        return ans == (int) 1e9 ? -1 : ans;
    }

    private int getMirrorPair(int num) {
        int ans = 0;

        while(num > 0) {
            int r = num % 10;
            num /= 10;

            ans = ans * 10 + r;
        }

        return ans;
    }
}