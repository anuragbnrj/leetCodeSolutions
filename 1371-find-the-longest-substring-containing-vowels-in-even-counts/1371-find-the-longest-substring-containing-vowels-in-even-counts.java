class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> firstOccurrence = new HashMap<>();

        int[] currentState = {0, 0, 0, 0, 0};
        firstOccurrence.put(getIntegerState(currentState), -1);

        Map<Character, Integer> idxMap = new HashMap<>();
        idxMap.put('a', 0);
        idxMap.put('e', 1);
        idxMap.put('i', 2);
        idxMap.put('o', 3);
        idxMap.put('u', 4);

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')  {
                int idx = idxMap.get(ch);
                currentState[idx] = currentState[idx] ^ 1;
            }

            int integerState = getIntegerState(currentState);

            if (firstOccurrence.containsKey(integerState)) {
                ans = Math.max(ans, i - firstOccurrence.get(integerState));
            } else {
                firstOccurrence.put(integerState, i);
            }
        }

        return ans;
    }

    private int getIntegerState(int[] currentState) {
        int integerState = 0;
        for (int i = 0; i < 5; i++) {
            integerState = integerState + (int) Math.pow(10, i) * currentState[i];
        }

        return integerState;
    }
}