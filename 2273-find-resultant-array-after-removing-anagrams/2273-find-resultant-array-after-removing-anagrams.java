class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (st.isEmpty()) st.push(word);

            String top = st.peek();

            if (!isAnagram(top, word)) st.push(word);
        }

        List<String> ans = new ArrayList<>(st);

        return ans;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[26];
        for (char ch : s1.toCharArray()) {
            freq[ch - 'a'] += 1;
        }

        for (char ch: s2.toCharArray()) {
            if (freq[ch - 'a'] == 0) return false;

            freq[ch - 'a'] -= 1;
        }

        return true;
    }
}