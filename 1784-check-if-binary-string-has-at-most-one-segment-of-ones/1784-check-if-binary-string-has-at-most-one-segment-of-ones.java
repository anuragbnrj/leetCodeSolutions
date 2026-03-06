class Solution {
    public boolean checkOnesSegment(String s) {
        int len = s.length();

        boolean hasStarted = false;
        for (int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '1') {
                if (!hasStarted) hasStarted = true;
            } else {
                if (hasStarted) return false;
            }
        }
        
        return true;
    }
}