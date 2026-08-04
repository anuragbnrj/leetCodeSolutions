class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> present = new HashSet<>();
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int num : nums) {
            present.add(num);

            smallest = Math.min(smallest, num);
            largest = Math.max(largest, num);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = smallest; i <= largest; i++) {
            if (!present.contains(i)) {
                ans.add(i);
            }
        }
        
        return ans;
    }
}