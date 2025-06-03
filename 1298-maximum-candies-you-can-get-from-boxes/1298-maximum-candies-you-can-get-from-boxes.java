class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int len = status.length;

        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < initialBoxes.length; i++) {
            int box = initialBoxes[i];
            if (status[box] == 1) {
                q.offer(box);
            }
        }

        boolean[] boxAvailable = new boolean[len];
        while(!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                int box = q.poll();
                ans += candies[box];

                for (int containedBox : containedBoxes[box]) {
                    boxAvailable[containedBox] = true;

                    if (status[containedBox] == 1) {
                        q.offer(containedBox);
                    }
                }

                for (int keyNumber : keys[box]) {
                    status[keyNumber] = 1;

                    if (boxAvailable[keyNumber]) {
                        q.offer(keyNumber);
                    }
                }
            }
        }

        return ans;
    }
}