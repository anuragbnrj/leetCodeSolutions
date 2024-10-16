class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            return -1 * Integer.compare(p1.freq, p2.freq);
        });
        if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));

        while (pq.size() >= 2) {
            Pair top = pq.poll();
            Pair second = pq.poll();

            if (sb.length() >= 2) {
                if (sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2) && sb.charAt(sb.length() - 1) == top.ch) {
                    sb.append(second.ch);
                    second.freq -= 1;
                } else {
                    sb.append(top.ch);
                    top.freq -= 1;
                }
            } else {
                sb.append(top.ch);
                top.freq -= 1;
            }

            if (top.freq > 0) pq.add(top);
            if (second.freq > 0) pq.add(second);
        }

        if (pq.size() > 0) {
            Pair top = pq.poll();

            if (top.freq >= 2) {
                sb.append(top.ch);
                sb.append(top.ch);
            } else {
                sb.append(top.ch);
            }
        }

        return sb.toString();
    }

    class Pair {
        char ch;
        int freq;

        public Pair(char _ch, int _freq) {
            ch = _ch;
            freq = _freq;
        }
    }
}