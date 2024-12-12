class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int gift : gifts) {
            pq.add(gift);
        }

        for (int i = 0; i < k && pq.size() > 0; i++) {
            int top = pq.poll();

            top = (int) Math.sqrt(top);

            pq.add(top);
        }

        long ans = 0;
        while (pq.size() > 0) {
            int top = pq.poll();

            ans += top;
        }

        return ans;
    }
}