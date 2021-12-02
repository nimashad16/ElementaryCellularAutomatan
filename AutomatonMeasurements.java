
public class AutomatonMeasurements {

	public static int hammingDistance(Generation g1, Generation g2) {
		
		if(g1.size() != g2.size()) {
			throw new IllegalArgumentException();
		}
		
		int counter =0;
		for(int x =0; x <g1.size(); x++) {
			if(g1.getCell(x).getState() != g2.getCell(x).getState()) {
				counter++;
			}
		}
					
		return counter;
	}
	
	
	public static int hammingDistance(int stepNum, Automaton a) throws InvalidStepNumException{
		
		if(stepNum <= 0) {
			throw new IllegalArgumentException();
		}
		
		return hammingDistance(a.getGeneration(stepNum -1), a.getGeneration(stepNum));
		
	}
	
	public static int[] hammingDistances(Automaton a) throws InvalidStepNumException {
		
			int[] hamming = new int[a.getTotalSteps()];
			for(int x = 1; x <= hamming.length; x++) {
				hamming[x-1] = hammingDistance(x, a);
			}
			return hamming;
		
	}
	
	public static int[] subruleCount(int stepNum , Automaton a) throws InvalidStepNumException{
		
		if(stepNum <= 0) {
			throw new InvalidStepNumException();
		}
		
		int[] subruleCounter = new int[a.getRule().getNumSubrules()];
		
		Generation generation = a.getGeneration(stepNum);
		
		for(int x =0; x< generation.size(); x++) {
			EvolvedCell evolvedCell = ((EvolvedCell) generation.getCell(x));
			++subruleCounter[evolvedCell.getSubruleNum()];
			
		}
		
		return subruleCounter;
		
	}
	
	public static int[][] subruleCounts(Automaton a) throws InvalidStepNumException {
		
		int[][] subruleCounter = new int[a.getTotalSteps()][a.getRule().getNumSubrules()];
		
		for(int x = 1; x <= subruleCounter.length; x++) {
			subruleCounter[x -1] = subruleCount(x,a);
		}
		return subruleCounter;
		
	}
}
