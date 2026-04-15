class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int len = words.length;

        for (int i = 0; i < len; i++) {
            int forwIdx = (startIndex + i) % len;
            int backIdx = (((startIndex - i) % len) + len) % len;

            if (words[forwIdx].equals(target) || words[backIdx].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}