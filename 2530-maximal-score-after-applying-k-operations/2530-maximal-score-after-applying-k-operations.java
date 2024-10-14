class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return (-1 * Integer.compare(a, b));
        });

        for (int num : nums) {
            pq.add(num);
        }

        long ans = 0;
        for (int i = 0; i < k; i++) {
            int top = pq.poll();

            ans += top;
            top = (int) Math.ceil((1.0 * top) / 3);

            pq.add(top);
        }

        return ans;
    }
}