class Solution {
    public int equalDigitFrequency(String s) {
        int len = s.length();
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            int[] freq = new int[10];
            for (int j = i; j < len; j++) {
                char ch = s.charAt(j);
                sb.append(ch);

                freq[ch - '0'] += 1;
                Set<Integer> uniqueFreqs = new HashSet<>();
                for (int k = 0; k < 10; k++) {
                    if (freq[k] != 0) {
                        uniqueFreqs.add(freq[k]);
                    }
                }

                if (uniqueFreqs.size() == 1) {
                    visited.add(sb.toString());
                }
            }   
        }

        return visited.size();
    }
}