class Solution {
    public String fractionAddition(String expression) {
        List<String> fractions = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-') {
                if (curr.length() > 0) {
                    fractions.add(curr.toString());
                } 

                curr = new StringBuilder(); 
            }

            curr.append(ch);
        }

        if (curr.length() > 0) {
            fractions.add(curr.toString());
        } 

        // for (String f : fractions) {
        //     System.out.println(f);
        // }

        int n = fractions.size();
        long[] nums = new long[n];
        long[] dens = new long[n];
        
        for (int i = 0; i < n; i++) {
            String[] temp = fractions.get(i).split("/");

            long num = Long.parseLong(temp[0]);
            long den = Long.parseLong(temp[1]);

            nums[i] = num;
            dens[i] = den;            
        }

        long lcmm = lcm(dens);
        long fnum = 0, fden = lcmm;
        for (int i = 0; i < n; i++) {
            fnum += nums[i] * (lcmm / dens[i]);
        }
        long hcf = gcd(fnum, fden);
        fnum = fnum / hcf;
        fden = fden / hcf;

        String ans = Long.toString(fnum) + "/" + Long.toString(fden);

        return ans;
    }

    private static long safe_mod(long x, long m){
        x %= m;
        if(x<0) x += m;
        return x;
    }

    private static long[] inv_gcd(long a, long b){
        a = safe_mod(a, b);
        if(a==0) return new long[]{b,0};

        long s=b, t=a;
        long m0=0, m1=1;
        while(t>0){
            long u = s/t;
            s -= t*u;
            m0 -= m1*u;
            long tmp = s; s = t; t = tmp;
            tmp = m0; m0 = m1; m1 = tmp;
        }
        if(m0<0) m0 += b/s;
        return new long[]{s,m0};
    }

    public static long gcd(long... a){
        if(a.length == 0) return 0;
        long r = java.lang.Math.abs(a[0]);
        for(int i=1; i<a.length; i++){
            if(a[i]!=0) {
                if(r==0) r = java.lang.Math.abs(a[i]);
                else r = inv_gcd(r, java.lang.Math.abs(a[i]))[0];
            }
        }
        return r;
    }

    public static long lcm(long... a){
        if(a.length == 0) return 0;
        long r = java.lang.Math.abs(a[0]);
        for(int i=1; i<a.length; i++){
            r = r / gcd(r,java.lang.Math.abs(a[i])) * java.lang.Math.abs(a[i]);
        }
        return r;
    }
}