class Solution {
    public int maximumLength(String s) {
        int len = s.length();
        Map<String, Integer> specialSubstringCount = new HashMap<>();

        for (int i = 0; i < len; i++) {
            String substr = "";
            for (int j = i; j < len; j++) {
                substr += s.charAt(j);

                if (isSpecial(substr)) {
                    specialSubstringCount.put(substr, specialSubstringCount.getOrDefault(substr, 0) + 1);
                }
            }
        }

        int currMaxLen = -1;
        for (Map.Entry<String, Integer> entry : specialSubstringCount.entrySet()) {
            String substr = entry.getKey();
            int count = entry.getValue();

            if (count >= 3 && substr.length() > currMaxLen) {
                currMaxLen = substr.length();
            }
        }

        return currMaxLen;
    }

    private boolean isSpecial(String s) {
        Map<Character, Integer> freqCount = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqCount.put(ch, freqCount.getOrDefault(ch, 0) + 1);
        }

        if (freqCount.size() == 1) {
            return true;
        }
        return false;
    }
}