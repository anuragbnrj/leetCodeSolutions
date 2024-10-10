class Solution {
    public int maxWidthRamp(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];

            if (list.size() == 0) {
                list.add(i);
            } else {
                if (curr < nums[list.get(list.size() - 1)]) {
                    list.add(i);
                } else {
                    int rampSize = i - getLowerBoundIdx(list, curr, nums);
                    ans = Math.max(ans, rampSize);
                }
            }
        }

        return ans;
    }

    private int getLowerBoundIdx(ArrayList<Integer> list, int element, int[] nums) {
        int beg = 0;
        int end = list.size();

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (nums[list.get(mid)] > element) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }
}