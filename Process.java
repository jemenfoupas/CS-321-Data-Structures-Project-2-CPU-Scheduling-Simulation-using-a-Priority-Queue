public class Process implements  ProcessInterface, Comparable<Process> {
	private int priority;
	private int timeRemaining;
	private int arrivalTime;
	private int waitingTime;
	
	
	public Process(int priority, int arrivalTime, int timeRemaining) {
		this.priority = 0;
		this.waitingTime = 0;
		this.priority = priority;
		this.arrivalTime =  arrivalTime;
		this.timeRemaining = timeRemaining;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public int getTimeRemaining() {
		return timeRemaining;
	}

	@Override
	public void decrementTimeRemaining() {
		timeRemaining -= 1;
	}

	@Override
	public boolean finished() {
		if(timeRemaining == 0) return true;
		return false;
	}

	@Override
	public int getArrivalTime() {
		return arrivalTime;
	}

	@Override
	public int getWaitingTime() {
		return waitingTime;
	}

	@Override
	public void incrementWaitingTime() {
		waitingTime += 1;
	}

	@Override
	public void resetWaitingTime() {
		waitingTime = 0;
	}

	@Override
	public int compareTo(Process o) {
		if(this.priority > o.priority) return 1;
		else if(this.priority < o.priority) return -1;
		else if(this.priority == o.priority) {
			if(this.arrivalTime < o.arrivalTime) return 1;
			if(this.arrivalTime > o.arrivalTime) return -1;
		};
		return 0;
	}

}
