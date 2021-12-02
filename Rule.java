
public abstract class Rule  {

	private int ruleNum;
	
	protected Rule(int ruleNum) {
		this.ruleNum = ruleNum;
	}
	
	public int getRuleNum(){
		return ruleNum;
	}
	
	public Generation evolve(Generation gen, BoundaryConditions bc) {
		EvolvedCell[] cells = new EvolvedCell[gen.size()];
		
		for(int x = 0; x < gen.size(); x++) {
			Cell[] neighborhood = getNeighborhood(x,gen,bc);
			cells[x] = evolve(neighborhood);
		}
		return  new Generation(cells);
		
	}
	
	public abstract int getNumSubrules();
	
	public abstract Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc);
	
	public abstract EvolvedCell evolve(Cell[] neighborhood);
	
	public abstract String toString();
	
}
