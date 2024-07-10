class Solution {
    public int minOperations(String[] logs) {
        int n = logs.length;

        Stack<String> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            String log = logs[i];

            if (log.equals("../")){
                if (st.size() > 0) {
                    st.pop();
                }
            } else if (log.equals("./")) {

            } else {
                st.push(log);
            }
        }

        return st.size();
    }
}