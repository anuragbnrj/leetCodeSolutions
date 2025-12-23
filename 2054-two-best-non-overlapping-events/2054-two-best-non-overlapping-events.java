class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b)-> {
            if (a[1] == b[1]) {
                if (a[2] == b[2]) {
                    return Integer.compare(b[0], a[0]);
                }

                return Integer.compare(a[2], b[2]);
            }

            return Integer.compare(a[1], b[1]);
        });

        TreeMap<Integer, Integer> bestEndingAtOrBefore = new TreeMap<>();
        bestEndingAtOrBefore.put(0, 0);
        int bestTillNow = 0;
        int ans = 0;
        for (int i = 0; i < events.length; i++) {
            int beg = events[i][0];
            int end = events[i][1];
            int val = events[i][2];

            int otherEvent = bestEndingAtOrBefore.get(bestEndingAtOrBefore.floorKey(beg - 1));

            ans = Math.max(ans, otherEvent + val);

            bestTillNow = Math.max(bestTillNow, val);

            bestEndingAtOrBefore.put(end, Math.max(bestEndingAtOrBefore.getOrDefault(end, 0), bestTillNow));
        }

        return ans;
    }
}