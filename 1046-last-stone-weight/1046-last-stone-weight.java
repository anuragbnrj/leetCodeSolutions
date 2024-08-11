class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(stones[i]);
        }

        while (pq.size() >= 2) {
            int y = pq.poll();
            int x = pq.poll();

            if (y != x) {
                pq.add(y - x);
            }
        }
        
        if (pq.size() == 1) {
            return pq.peek();
        }
        return 0;
    }
}