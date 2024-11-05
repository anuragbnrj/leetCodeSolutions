class Solution {
    public boolean isAnagram(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if (lenS != lenT) {
            return false;
        }

        Map<Character, Integer> freqS = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqS.put(ch, freqS.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> freqT = new HashMap<>();
        for (char ch : t.toCharArray()) {
            if (!freqS.containsKey(ch)) {
                return false;
            }

            int val = freqS.get(ch) - 1;

            if (val < 0) {
                return false;
            }

            freqS.put(ch, val);
        }

        return true;
    }
}