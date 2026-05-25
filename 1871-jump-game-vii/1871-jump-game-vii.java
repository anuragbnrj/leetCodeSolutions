class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int size = s.length();

        if (s.charAt(size - 1) == '1') return false;

        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(List.of(minJump, maxJump));

        int currIdx = 0;
        while (!q.isEmpty()) {
            List<Integer> front = q.poll();
            int intervalBeg = front.get(0);
            int intervalEnd = front.get(1);

            for (currIdx = Math.max(currIdx, intervalBeg); currIdx <= intervalEnd && currIdx < size; currIdx++) {
                char ch = s.charAt(currIdx);

                if (ch == '1') {
                    continue;
                }

                if (currIdx == (size - 1)) return true;

                q.offer(List.of(currIdx + minJump, currIdx + maxJump));
            }
        }

        return false;
    }
}