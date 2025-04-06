class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int[] lis = new int[len];
        int[] prevIdx = new int[len];
        for (int i = 0; i < len; i++) {
            lis[i] = 1;
            prevIdx[i] = i;
        }

        int globalMax = 1;
        int globalMaxIdx = 0;
        for (int curr = 0; curr < len; curr++) {
            int currMax = 1;
            int maxIdx = curr;
            for (int prev = 0; prev < curr; prev++) {
                if ((nums[curr] % nums[prev]) == 0 && lis[prev] + 1 > currMax) {
                    currMax = lis[prev] + 1;
                    maxIdx = prev;
                }
            }

            lis[curr] = currMax;
            prevIdx[curr] = maxIdx;

            if (currMax > globalMax) {
                globalMax = currMax;
                globalMaxIdx = curr;
            }
        }

        // System.out.println(Arrays.toString(lis));
        // System.out.println(Arrays.toString(prevIdx));

        List<Integer> ans = new ArrayList<>();
        int temp = globalMaxIdx;
        for (int i = 0; i < globalMax; i++) {
            ans.add(nums[temp]);
            temp = prevIdx[temp];
        }

        return ans;
    }
}
