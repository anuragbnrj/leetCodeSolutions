class Solution {
    public boolean checkString(String s) {
        boolean seenB = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                if (seenB == true) {
                    return false;
                }
            } else {
                seenB = true;
            }
        }
        
        return true;
    }
}