class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int beg = i + 1, end = len - 1;
            int req = -nums[i];

            while (beg < end) {
                if (nums[beg] + nums[end] == req) {
                    ans.add(List.of(nums[i], nums[beg], nums[end]));
                    // System.out.println("Found: " + List.of(nums[i], nums[beg], nums[end]));
                    beg++;
                    end--;

                    while (beg < end && nums[beg] == nums[beg - 1]) {
                        beg++;
                    }
                    
                    while (beg < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (nums[beg] + nums[end] < req) {
                    beg++;
                } else {
                    end--;
                }
            }
        }

        return ans;
    }
}