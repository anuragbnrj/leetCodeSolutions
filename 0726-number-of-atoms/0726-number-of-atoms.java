class Solution {
    public String countOfAtoms(String s) {
        s = '(' + s + ')';
        int n = s.length();

        TreeMap<String, Integer> freq = new TreeMap<>();
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < n; ) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(new Pair(ch + "", 0));
                i++;
                debug(st);
            } else if ('A' <= ch && ch <= 'Z') {
                String curr = "" + ch;
                i++;
                while (i < n && 'a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                    curr += s.charAt(i);
                    i++;
                }

                String countStr = "";
                int count = 0;
                while (i < n && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    countStr += s.charAt(i);
                    i++;
                }
                if (countStr.length() == 0) {
                    count = 1;
                } else {
                    count = Integer.parseInt(countStr);
                }

                st.push(new Pair(curr, count));
                debug(st);
            } else {
                i++;
                String countStr = "";
                int multiplier = 0;
                while (i < n && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    countStr += s.charAt(i);
                    i++;
                }
                if (countStr.length() == 0) {
                    multiplier = 1;
                } else {
                    multiplier = Integer.parseInt(countStr);
                }

                while (st.size() > 0 && !st.peek().str.equals("(")) {
                    Pair top = st.peek();
                    st.pop();
                    
                    int prev = 0;
                    if (freq.containsKey(top.str)) {
                        prev = freq.get(top.str);
                    }
                    int totalCount = top.count + prev;

                    freq.put(top.str, totalCount);
                }
                st.pop();

                for (String key : freq.keySet()) {
                    int count = freq.get(key);
                    count = count * multiplier;

                    freq.put(key, count);
                }

                // debug(st);
            }
        }

        StringBuilder res = new StringBuilder();
        for (String key : freq.keySet()) {
            res.append(key);
            int count = freq.get(key);
            if (count > 1) {
                res.append(count);
            }
        }

        return res.toString();
    }

    public static void debug(Object... o){
        System.out.println(Arrays.deepToString(o));
    }

    class Pair {
        String str;
        int count;

        public Pair(String s, int c) {
            this.str = s;
            this.count = c;
        }

        public String toString() {
            return "s: " + this.str + ", c: " + this.count;
        }
    }
}