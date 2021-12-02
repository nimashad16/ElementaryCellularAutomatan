import java.util.ArrayList;
import java.util.List;

public class Automaton {

	private Rule rule;
	private List<Generation> generations = new ArrayList<Generation>();
	private BoundaryConditions bc;
	

	
	
	public Automaton(Rule rule, Generation init, BoundaryConditions bc) {
		this.rule = rule;
		this.bc = bc;
		this.generations.add(init);
	}
	
	public Rule getRule() {
		return rule;
	}
	
	public Generation getGeneration(int stepNum) throws InvalidStepNumException{
		if(stepNum < 0) {
			throw new InvalidStepNumException();
		}
		if(getTotalSteps() < stepNum) {
			int steps = stepNum - getTotalSteps();
			evolve(steps);
			
		}
		return  generations.get(stepNum) ;
		
	}
	
	public BoundaryConditions getBoundaryConditions() {
		return bc;
		
	}
	
	public void evolve(int numSteps)  {
		
			if(numSteps > 0) {						
				for(int x =0; x <numSteps; x++) {
					Generation currentGeneration = generations.get(getTotalSteps());
					generations.add(rule.evolve(currentGeneration,bc));
				}
			}
		}	
		
	public int getTotalSteps() {
		return generations.size() -1;
	}
	
	public String toString() {
		return generations.get(getTotalSteps()).toString();
		
	}
	
	public String getHistory() {
		String pastSteps = "";
		
		for(int x =0; x < generations.size();x++) {
			pastSteps = pastSteps + generations.get(x).toString();
			
			if(x < getTotalSteps()) {
				pastSteps = pastSteps + "\n";
			}
		}
		return pastSteps;
	}
	
}
