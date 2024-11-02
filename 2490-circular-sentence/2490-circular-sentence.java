class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");

        int len = words.length;
        boolean isCircular = true;
        for (int i = 0; i < len; i++) {
            String curr = words[i];
            String next = words[(i + 1) % len];

            if (curr.charAt(curr.length() - 1) != next.charAt(0)) {
                isCircular = false;
                break;
            }
        }
        
        return isCircular;
    }
}