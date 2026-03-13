class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int len = workerTimes.length;
        PriorityQueue<Worker> pq = new PriorityQueue<>((a, b) -> {
            return Long.compare(1L * ((a.turn * (a.turn + 1)) / 2) * a.timeTaken, 1L * ((b.turn * (b.turn + 1)) / 2) * b.timeTaken);
        });

        for (int i = 0; i < len; i++) {
            pq.offer(new Worker(1, workerTimes[i]));
        }

        long ans = 0L;
        while (mountainHeight > 0) {
            Worker front = pq.poll();

            ans = Math.max(ans, 1L *  ((front.turn * (front.turn + 1)) / 2) * front.timeTaken);

            front.turn += 1;
            pq.offer(front);

            mountainHeight -= 1;
        }

        return ans;
    }
}

class Worker {
    long turn;
    long timeTaken;

    public Worker(int _turn, int _timeTaken) {
        turn = _turn;
        timeTaken = _timeTaken;
    }
}
