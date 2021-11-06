
public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface{
	
	
	public MyPriorityQueue() {
		super();
	}

	@Override
	public void enqueue(Process p) {
		maxHeapInsert(p);
	}

	@Override
	public Process dequeue() {
		Process pro = super.heapExtractMax();
		return pro;
	}

	@Override
	public boolean isEmpty() {
		return heapSize == 0;
	}

	@Override
	public void update(Process next, int timeToIncrementPriority, int maxPriority) {
		next.resetWaitingTime();
		for(int i = 0; i < heapSize; i++) {
			array[i].incrementWaitingTime();
			if(array[i].getWaitingTime() >= timeToIncrementPriority) {
				array[i].resetWaitingTime();
				if(array[i].getPriority() < maxPriority) {
					array[i].setPriority(array[i].getPriority() + 1);
					heapIncreaseKey(i, array[i]);
				}
			}
		} 
	}
	
}
