class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<FinalExam> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(b.getPassRatioGain(), a.getPassRatioGain())
        );

        for (int[] c : classes) {
            pq.offer(new FinalExam(c[0], c[1]));
        }

        while (extraStudents > 0) {
            FinalExam top = pq.poll();
            top.pass++;
            top.total++;
            pq.offer(top);
            extraStudents--;
        }

        double passRatioSum = 0.0;
        while (!pq.isEmpty()) {
            FinalExam top = pq.poll();
            passRatioSum += top.getPassRatio();
        }

        return passRatioSum / classes.length;
    }

    class FinalExam {
        int pass;
        int total;

        public FinalExam(int _pass, int _total) {
            pass = _pass;
            total = _total;
        }

        public double getPassRatio() {
            return (1.0 * pass) / total;
        }

        public double getPassRatioGain() {
            return ((1.0 * (pass + 1)) / (total + 1)) - getPassRatio();
        }
    }

}