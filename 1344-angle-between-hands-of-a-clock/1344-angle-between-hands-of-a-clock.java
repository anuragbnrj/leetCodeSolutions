class Solution {
    public double angleClock(int hour, int minutes) {
        double hourDegree = (360.0 / 12.0) * (hour % 12) + (360.0 / 12) * (minutes / 60.0);
        // System.out.println("hourDegree: " + hourDegree);

        double minuteDegree = 360.0 * (minutes / 60.0);
        // System.out.println("minuteDegree: " + minuteDegree);

        double diff1 = Math.abs(hourDegree - minuteDegree);

        double diff2 = 360 - diff1;

        return Math.min(diff1, diff2);
    }
}