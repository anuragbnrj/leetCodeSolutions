class Solution {
    public int tupleSameProduct(int[] nums) {
        int len = nums.length;

        Map<Integer, Integer> productCount = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int currProduct = nums[i] * nums[j];

                int existing = productCount.getOrDefault(currProduct, 0);
                ans += (existing * 8);
                productCount.put(currProduct, existing + 1);
            }
        }

        return ans;
    }
}