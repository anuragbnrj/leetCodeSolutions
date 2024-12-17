class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'] += 1;
        }

        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return Character.compare(b.getKey(), a.getKey());
        });

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer( new Pair((char) ('a' + i), freq[i]) );
            }
        }

        StringBuilder ans = new StringBuilder();
        char prevChar = 'A';
        int prevCharCount = 0;
        while (pq.size() > 1) {
            Pair<Character, Integer> top = pq.poll();
            Pair<Character, Integer> top2 = pq.poll();

            if (top.getKey() == prevChar && prevCharCount == repeatLimit) {
                ans.append(top2.getKey());

                prevChar = top2.getKey();
                prevCharCount = 1;

                if (top2.getValue() - 1 > 0) {
                    pq.offer(new Pair(top2.getKey(), top2.getValue() - 1));
                }
                pq.offer(top);
            } else {
                int i = 0;
                for (; i < Math.min(top.getValue(), repeatLimit); i++) {
                    ans.append(top.getKey());
                }

                prevChar = top.getKey();
                prevCharCount = i;

                if (top.getValue() - i > 0) {
                    pq.offer(new Pair(top.getKey(), top.getValue() - i));
                }
                pq.offer(top2);
            }
        }

        if (pq.size() > 0) {
            Pair<Character, Integer> top = pq.poll();

            int i = 0;
            for (; i < Math.min(top.getValue(), repeatLimit); i++) {
                ans.append(top.getKey());
            }
        }

        return ans.toString();
    }
}