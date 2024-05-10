class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        int n1 = pq.poll();
        int n2 = pq.poll();

        return (n1 - 1) * (n2 - 1);
    }
}