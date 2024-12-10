class Solution {
    public int maximumLength(String s) {
        int len = s.length();
        Map<Pair<Character, Integer>, Integer> freqCount = new HashMap<>();

        StringBuilder currSubstring = new StringBuilder();
        for (int right = 0; right < len; right++) {
            if (currSubstring.length() > 0 && s.charAt(right) != currSubstring.charAt(currSubstring.length() - 1)) {
                currSubstring = new StringBuilder();
            }

            currSubstring.append(s.charAt(right));

            Pair<Character, Integer> pair = new Pair<>(s.charAt(right), currSubstring.length());

            freqCount.put(pair, freqCount.getOrDefault(pair, 0) + 1);
        }

        System.out.println(freqCount.toString());

        int currMax = -1;
        for (Map.Entry<Pair<Character, Integer>, Integer> entry : freqCount.entrySet()) {
            Pair<Character, Integer> pair = entry.getKey();
            int size = pair.getValue();
            int count = entry.getValue();

            if (count >= 3 && size > currMax) {
                currMax = size;
            }

            if (size > 1) {
                Pair<Character, Integer> prev1 = new Pair(pair.getKey(), size - 1);
                int prev1Count = freqCount.getOrDefault(prev1, 0);

                prev1Count += 1;

                if (prev1Count >= 3 && size - 1 > currMax) {
                    currMax = size - 1;
                }
            }

            if (size > 2) {
                Pair<Character, Integer> prev2 = new Pair(pair.getKey(), size - 2);
                int prev2Count = freqCount.getOrDefault(prev2, 0);

                prev2Count += 2;

                if (prev2Count >= 3 && size - 2 > currMax) {
                    currMax = size - 2;
                }
            }
        }

        return currMax;
    }
}