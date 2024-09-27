class MyCalendarTwo {
    TreeMap<Integer, Integer> freq; 

    public MyCalendarTwo() {
        freq = new TreeMap<>();
    }
    
    public boolean book(int start, int finish) {
        // System.out.println("----------- book() called -----------");
        // System.out.println("start: " + start + ", finish: " + finish);

        int begFreq = freq.getOrDefault(start, 0) + 1;
        freq.put(start, begFreq);

        int endFreq = freq.getOrDefault(finish, 0) - 1;
        freq.put(finish, endFreq);

        int currBookings = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            // System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
            currBookings += entry.getValue();

            if (currBookings > 2) {
                begFreq = freq.getOrDefault(start, 0) - 1;
                freq.put(start, begFreq);

                endFreq = freq.getOrDefault(finish, 0) + 1;
                freq.put(finish, endFreq);

                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */