class MyCalendar {
    TreeSet<Event> events;

    public MyCalendar() {
        events = new TreeSet<>((a, b) -> {
            if (a.beg == b.beg) {
                return Integer.compare(a.end, b.end);
            }

            return Integer.compare(a.beg, b.beg);
        });    
    }
    
    public boolean book(int start, int finish) {
        finish -= 1;

        Event curr = new Event(start, finish);
        Event prev = events.floor(curr);
        Event next = events.ceiling(curr);

        int ctr = 0;
        if (prev == null || prev.end < curr.beg) ctr += 1;

        if (next == null || curr.end < next.beg) ctr += 1;

        if (ctr < 2) {
            return false;
        }

        events.add(curr);
        return true;
    }

    class Event implements Comparator<Event> {
        int beg;
        int end;

        public Event(int start, int finish) {
            beg = start;
            end = finish;
        }

        @Override
        public int compare(Event a, Event b) {
            if (a.beg == b.beg) {
                return Integer.compare(a.end, b.end);
            }
            return Integer.compare(a.beg, b.beg);
        }

        // @Override
        // public boolean equals(Object obj) {
        //     if (this == obj) return true;
        //     if (obj == null || getClass() != obj.getClass()) return false;
        //     Event event = (Event) obj;
        //     return beg == event.beg && end == event.end;
        // }

        // @Override
        // public int hashCode() {
        //     return Objects.hash(beg, end);
        // }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */