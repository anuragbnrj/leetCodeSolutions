class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        boolean isPossible = false;
        for (int i = 0; i < goal.length(); i++) {
            StringBuilder rotated = new StringBuilder();
            for (int j = 0; j < goal.length(); j++) {
                rotated.append(goal.charAt((i + j) % goal.length()));
            }

            if (rotated.toString().equals(s)) {
                isPossible = true;
                break;
            }
        }

        return isPossible;
    }
}