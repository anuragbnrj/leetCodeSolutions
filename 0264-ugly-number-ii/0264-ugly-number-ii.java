class Solution {

    public int nthUglyNumber(int n) {
        Set<Long> alreadyUsed = new HashSet<>();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);

        int processed = 0;
        long ans = 0;
        while (processed < n) {
            long top = pq.peek();
            pq.poll();

            if (alreadyUsed.contains(top)) continue;
            else alreadyUsed.add(top);

            processed += 1;
            if (processed == n) {
                ans = top;
                break;
            }

            pq.add(top * 2);
            pq.add(top * 3);
            pq.add(top * 5);
        }

        return (int) ans;
    }
    
}