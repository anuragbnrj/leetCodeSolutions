class Solution {
    public String op1(String s, int a){
        char[] c = s.toCharArray();
        for(int i=1; i<c.length; i+=2){
            int x = c[i]-'0';
            int y = (x+a)%10;
            c[i] = (char)('0'+y);
        }
        return new String(c);
    }
    public String op2(String s, int b){
        int n = s.length();
        return s.substring(n-b)+s.substring(0,n-b);
    }
    public String findLexSmallestString(String s, int a, int b) {
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        set.add(s);
        String ans = s;
        while(!q.isEmpty()){
            String t = q.poll();
            String x = op1(t,a);
            String y = op2(t,b);
            if(!set.contains(x)){
                set.add(x);
                q.offer(x);
                if(ans.compareTo(x)>0){
                    ans = x;
                }
            }
            if(!set.contains(y)){
                set.add(y);
                q.offer(y);
                if(ans.compareTo(y)>0){
                    ans = y;
                }
            }
            
            
        }
        return ans;
    }
}