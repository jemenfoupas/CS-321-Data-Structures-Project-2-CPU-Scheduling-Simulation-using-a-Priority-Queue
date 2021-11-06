import java.util.Random;

public class ProcessGenerator implements ProcessGeneratorInterface{

	private double probability;
	
	private Random random;
	
	public ProcessGenerator(double probability) {
		this.probability = probability;
		this.random = new Random();
	}
	
	public ProcessGenerator(double probability, long seed) {
		this.random = new Random(seed);
		this.probability = probability;
	}

	@Override
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxPriority) {
		Process process = new Process(random.nextInt(maxPriority) + 1, currentTime, random.nextInt(maxProcessTime) + 1);
		return process;
	}

	@Override
	public boolean query() {
		double rand = random.nextDouble();
		if(rand < probability) return true;
		return false;
	}
}
