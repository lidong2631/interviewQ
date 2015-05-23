From Groupon

Great explanation http://www.ardendertat.com/2011/11/03/programming-interview-questions-13-median-of-integer-stream/

http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/

java implementation http://www.dsalgo.com/2013/02/RunningMedian.php.html

from DsAlgo

public class RunningMedian {
	PriorityQueue<Integer> maxHeap;	//maxHeap contains all the values less than median. root is the max value
	PriorityQueue<Integer> minHeap;	//minHeap contains all the values larger than median. root is the min value

	public RunningMedain() {
		maxHeap = new PriorityQueue<Integer>(20, new Comparator<Integer>() {	//java中PriorityQueue是由小往大排 这里maxHeap是由大往小排
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
			}
		});
		minHeap = new PriorityQueue<Integer>();
		minHeap.add(Integer.MAX_VALUE);
		maxHeap.add(Integer.MIN_VALUE);
	}

	public void insert(int num) {
		if(num>=minHeap.peek())
			minHeap.add(num);
		else
			maxHeap.add(num);
		if(minHeap.size()-maxHeap.size()==2)	//balance heap
			maxHeap.add(minHeap.poll());
		else if(maxHeap.size()-minHeap.size()==2)
			minHeap.add(maxHeap.poll());
	}

	public double getMedian() {
		if(maxHeap.size()==minHeap.size())
			return (maxHeap.peek()+minHeap.peek())/2;
		else if(maxHeap.size()>minHeap.size())
			return maxHeap.peek();
		else
			return minHeap.peek();
	}
}

insert O(logn) 
getMedian O(1)