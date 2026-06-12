class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int size = trips.length;

        int[][] event = new int[size * 2][2];
        for (int i = 0; i < size; i++) { 
            event[i * 2][0] = trips[i][1];
            event[i * 2][1] = trips[i][0];

            event[i * 2 + 1][0] = trips[i][2];
            event[i * 2 + 1][1] = trips[i][0] * -1;
        }
        Arrays.sort(event, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int currFilled = 0;
        for (int i = 0; i < event.length; i++) {
            currFilled += event[i][1];

            if (currFilled > capacity) {
                return false;
            }
        }

        return true;
    }
}