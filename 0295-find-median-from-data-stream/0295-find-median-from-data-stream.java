class MedianFinder {

    private PriorityQueue<Integer> lowerHalf;
    private PriorityQueue<Integer> upperHalf;

    public MedianFinder() {
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        upperHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lowerHalf.offer(num);
    
        upperHalf.offer(lowerHalf.poll());
        
        if (lowerHalf.size() < upperHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }
    
    public double findMedian() {
        if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek();
        } else {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */