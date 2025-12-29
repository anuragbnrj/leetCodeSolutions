class Solution {
    private Map<String, Boolean> memo;

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        HashSet<String> allowedSet = new HashSet<>(allowed);
        Map<String, List<Character>> trans = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2); 
            char top = s.charAt(2);
            trans.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        memo = new HashMap<>();
        return isPyramidPossible(new StringBuilder(), new StringBuilder(bottom), trans);
    }

    private boolean isPyramidPossible(StringBuilder curr, StringBuilder bottom, Map<String, List<Character>> trans) {

        String memoKey = curr + "-" + bottom;
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        if (bottom.length() == 1) {
            return true;
        }

        if (curr.length() == bottom.length() - 1) {
            return isPyramidPossible(new StringBuilder(), curr, trans);
        }

        String key = bottom.substring(curr.length(), curr.length() + 2);;
        List<Character> choices = trans.get(key);
        if (choices == null) {
            memo.put(memoKey, false);
            return false;
        }

        for (char ch : choices) {
            curr.append(ch);
            if (isPyramidPossible(curr, bottom, trans)) {
                memo.put(memoKey, true);
                return true;
            }

            curr.deleteCharAt(curr.length() - 1);
        }

        memo.put(memoKey, false);
        return false;
    }
}