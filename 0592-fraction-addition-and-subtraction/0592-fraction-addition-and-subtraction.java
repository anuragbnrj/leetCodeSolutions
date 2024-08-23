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
        
        int fnum = 0, fden = 1;
        for (int i = 0; i < fractions.size(); i++) {
            String[] temp = fractions.get(i).split("/");

            int currNum = Integer.parseInt(temp[0]);
            int currDen = Integer.parseInt(temp[1]);

            fnum = fnum * currDen + currNum * fden;
            fden = fden * currDen;

            System.out.println("i: " + i + ", fnum: " + fnum + ", fden: " + fden);           
        }

        
        int gcd = Math.abs(euclidsGcd(fnum, fden));
        fnum = fnum / gcd;
        fden = fden / gcd;

        String ans = Integer.toString(fnum) + "/" + Integer.toString(fden);

        return ans;
    }

    private int euclidsGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
}