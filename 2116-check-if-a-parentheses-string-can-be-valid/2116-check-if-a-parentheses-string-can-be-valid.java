class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> buffer = new Stack<>();
        for (int i = 0; i < locked.length(); i++) {
            char ch = locked.charAt(i);
            if (ch == '0') {
                buffer.push(i);
            } else {
                char curr = s.charAt(i);

                if (curr == '(') {
                    open.push(i);
                } else {
                    if (open.empty() && buffer.empty()) return false;

                    if (open.empty()) buffer.pop();
                    else open.pop();
                }
            }
        }

        if (open.size() > buffer.size()) return false;

        while (open.size() > 0) {
            int openTop = open.pop();
            int bufferTop = buffer.pop();

            if (openTop > bufferTop) return false;
        }

        if (buffer.size() % 2 == 1) return false;

        return true;
    }
}