class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int el : nums) {
            Integer count = freq.getOrDefault(el, 0);
            count++;

            freq.put(el, count);
        }

        List<Pair<Integer, Integer>> freqList = new ArrayList<>();
        freq.forEach((key, v) -> {
            freqList.add(new Pair(v, key));
        });
        Collections.sort(freqList, (p1, p2) -> {
            if (p1.first == p2.first) {
                return p2.second.compareTo(p1.second);
            } else {
                return p2.first.compareTo(p1.first);
            }
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            var el = freqList.get(i);
            res[i] = el.second;
        }

        return res;
    }
}

class Pair<A, B> {
    A first;
    B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
}