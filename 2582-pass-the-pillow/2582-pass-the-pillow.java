class Solution {
    public int passThePillow(int n, int time) {

        int curr = 1;
        int temp = 1;
        boolean forward = true;
        while (temp <= time) {
            // System.out.println("curr: " + curr);
            if (forward) {
                if (curr == n) {
                    curr = n - 1;
                    forward = false;
                } else {
                    curr += 1;
                }
            } else {
                if (curr == 1) {
                    curr = 2;
                    forward = true;
                } else {
                    curr -= 1;
                }
            }
            
            temp += 1;
        }

        return curr;
    }
}