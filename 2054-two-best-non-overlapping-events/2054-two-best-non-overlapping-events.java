class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } 

            return Integer.compare(a[0], b[0]);
        });

        TreeMap<Integer, Integer> maxFromThis = new TreeMap<>();
        int maxTillNow = 0;
        for (int i = events.length - 1; i >= 0 ; i--) {
            int[] event = events[i];

            if (event[2] > maxTillNow) {
                maxTillNow = event[2];    
            }

            maxFromThis.put(event[0], maxTillNow);
        }

        int ans = 0;
        for (int i = 0; i < events.length; i++) {
            int beg = events[i][0];
            int end = events[i][1];
            int val = events[i][2];

            Integer ceilKey = maxFromThis.ceilingKey(end + 1);

            int currVal = val;
            if (ceilKey != null) {
                currVal += maxFromThis.get(ceilKey);
            }

            ans = Math.max(ans, currVal);
        }

        return ans;
    }
}