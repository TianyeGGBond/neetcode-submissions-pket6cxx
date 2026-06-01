class MedianFinder {
    //larger part minHeap
    Queue<Integer> large;

    //smaller part maxHeap
    Queue<Integer> small;

    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        if(large.size() > small.size()) small.offer(large.poll());
    }
    
    public double findMedian() {
        if(small.size() > large.size()) return small.peek();

        return ((long)(small.peek() + large.peek()))/2.0;
    }
}
