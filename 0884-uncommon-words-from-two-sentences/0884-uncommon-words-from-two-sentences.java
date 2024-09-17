class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        TreeMap<String, Integer> wordFreq = new TreeMap<>();

        for (String s : s1.split(" ")) {
            int freq = wordFreq.getOrDefault(s, 0);
            freq += 1;
            wordFreq.put(s, freq); 
        }

        for (String s : s2.split(" ")) {
            int freq = wordFreq.getOrDefault(s, 0);
            freq += 1;
            wordFreq.put(s, freq);
        }

        List<String> ansList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            if (entry.getValue() == 1) {
                String str = entry.getKey();
                ansList.add(str);
            }
        }

        String[] ans = new String[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}