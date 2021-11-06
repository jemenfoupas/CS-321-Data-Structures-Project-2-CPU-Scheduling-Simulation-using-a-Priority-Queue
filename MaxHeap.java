public class MaxHeap {
	protected Process[] array;
	protected int heapSize;
	
	public MaxHeap() {
		array = new Process[10];
		heapSize = 0;
	}
	
	public void maxHeapify (int index) {
		int largest;
		int left = (index * 2) + 1;
		int right = (index * 2) + 2;
		
		if(left <= heapSize - 1 && array[left].compareTo(array[index]) == 1) {
			largest = left;
		} else {
			largest = index;
		} 
		
		if(right <= heapSize - 1 && array[right].compareTo(array[largest]) == 1) largest = right;
		
		if(largest != index) {
			Process exchange = array[index];
			array[index] = array[largest];
			array[largest] = exchange;
			maxHeapify(largest);
		}
	}
	
	public Process heapMaximum(Process[] array) {
		return array[0];
	}
	
	public Process heapExtractMax() {
		if(heapSize < 1) {
			return null;
		}
		
		Process max = array[0];
		array[0] = array[heapSize-1];
		heapSize--;
		maxHeapify( 0);
		return max;
	}
	
	public void heapIncreaseKey(int i, Process key) {
//		if(key.compareTo(array[i]) == -1) 
//			throw new HeapException("new key must be larger than current key"); ask about it
		
		array[i] = key;
		int parent = (i-1)/2;
		while(i > 0 && array[parent].compareTo(array[i]) == -1) {
			Process process = array[i];
			array[i] = array[parent];
			array[parent] = process;
			i = parent;
			parent = (i-1)/2;
		}
	}
	
	public void maxHeapInsert(Process key)  {
		if(array.length == heapSize) update();
		Process process = new Process(0, 0, 0);
		process.setPriority(Integer.MIN_VALUE);
		array[heapSize] = process;
		heapSize++;
		heapIncreaseKey(heapSize-1, key);
	}
	
	public void update() {
		Process[] array2 = new Process[heapSize * 2];
		for(int i = 0; i <array.length; i++) {
			array2[i] =	array[i] ;
		}
		//heapSize = heapSize * 2;
		array = array2;
	}
	

}
