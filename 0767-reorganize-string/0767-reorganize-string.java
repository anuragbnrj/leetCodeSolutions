class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];

        int maxFreq = 0;
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'] += 1;

            maxFreq = Math.max(maxFreq, freq[ch - 'a']);
        }

        int others = n - maxFreq;
        if (maxFreq - others > 1) {
            return "";
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.count, a.count);
        });
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.add(new Pair(freq[i], (char)('a' + i)));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= 2) {
            Pair top1 = maxHeap.poll();
            int count1 = top1.count;
            char ch1 = top1.ch;
            sb.append(ch1);

            Pair top2 = maxHeap.poll();
            int count2 = top2.count;
            char ch2 = top2.ch;
            sb.append(ch2);


            if (count1 > 1) {
                maxHeap.add(new Pair(count1 - 1, ch1));
            }

            if (count2 > 1) {
                maxHeap.add(new Pair(count2 - 1, ch2));
            }
        }

        if (maxHeap.size() > 0) {
            Pair top = maxHeap.poll();
            sb.append(top.ch);
        }

        return sb.toString();
    }

    class Pair {
        int count;
        char ch;

        public Pair(int ctr, char charac) {
            this.count = ctr;
            this.ch = charac;
        }
    }
}