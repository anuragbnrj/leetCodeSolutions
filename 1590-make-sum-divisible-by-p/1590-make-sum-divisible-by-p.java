class Solution {
    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        int tot = 0;
        for (int i = 0; i < len; i++) {
            tot = (tot + nums[i]) % p;
        }
        int modReq = tot % p;

        if (modReq == 0) return 0;

        int minLen = (int) 1e9;
        TreeMap<Integer, Integer> prevModOccur = new TreeMap<>();
        prevModOccur.put(0, -1);
        int currSumMod = 0;
        for (int i = 0; i < len; i++) {
            currSumMod = (currSumMod + nums[i]) % p;
            int prevMod = (((currSumMod - modReq) % p) + p) % p;

            if (prevModOccur.containsKey(prevMod)) {
                minLen = Math.min(minLen, (i - prevModOccur.get(prevMod)));
            }

            prevModOccur.put(currSumMod, i);
        }

        if (minLen == len) {
            return -1;
        }

        return minLen;
    }
}