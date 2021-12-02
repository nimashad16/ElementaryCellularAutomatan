
public class TotalisticRule extends Rule{
	
	private final int TOTAL_RULES = 63;
	private final int TOTAL_SUBRULES = 6;
	private final int LENGTH_NEIGHBORHOOD = 5;
	private String binaryRuleNum;
	
	public TotalisticRule(int ruleNum) throws InvalidRuleNumException {
		super(ruleNum);
		
		if(ruleNum > TOTAL_RULES || ruleNum < 0){
			throw new InvalidRuleNumException();
		}
		else {
			this.binaryRuleNum = ruleNumBinary(ruleNum);
		}
		}
	
	public int getNumSubrules() {
		return TOTAL_SUBRULES;
		
	}
	
	public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
		Cell[] neigh= new Cell[LENGTH_NEIGHBORHOOD];
		
		neigh[0] = bc.getNeighbor(cellIdx, -2, gen);
		neigh[1] = bc.getNeighbor(cellIdx, -1, gen);
		neigh[2] = bc.getNeighbor(cellIdx, 0, gen);
		neigh[3] = bc.getNeighbor(cellIdx, 1, gen);
		neigh[4] = bc.getNeighbor(cellIdx, 2, gen);
		
		return neigh;
		
	}
	
	private char conversion(char x) {
		if(x == '0')
			return '.';
		else
			return 'O';
	
	
	}
	
	public EvolvedCell evolve(Cell[] neighborhood) {
		
		String binaryNeigh = "";
		int counter =0;
		
		for(int x =0; x < neighborhood.length; x++) {
			if(neighborhood[x].toString().equals("O")) {
				binaryNeigh += "1";
			}
			else if(neighborhood[x].toString().equals(".")) {
				binaryNeigh += "0";
			}
		}
		
		for(int x =0; x < binaryNeigh.length(); x++) {
			if(binaryNeigh.charAt(x) == '1') {
				counter++;
			}
		}
		
		int subruleNum = LENGTH_NEIGHBORHOOD - counter;
		char ruleAsChar;
		
		ruleAsChar = binaryRuleNum.charAt(subruleNum);
		CellState state;
		if(ruleAsChar == '1') {
			state = CellState.ON;
		}
		else {
			state = CellState.OFF;
		}
		
		EvolvedCell evolvedCell = new EvolvedCell(state,counter);
		return evolvedCell;
		
		
	}
	
	private String ruleNumBinary(int ruleNum) {
		String stringRuleNum = Integer.toBinaryString(ruleNum);
		while(stringRuleNum.length() < 6) {
			stringRuleNum = "0" + stringRuleNum;
		}
		return stringRuleNum;
	}
	
	public String toString() {
		
		String line =  "5 4 3 2 1 0\n";
		for(int x = 0; x <6; x++) {
			if(x ==0) {
				line += conversion(binaryRuleNum.charAt(0));
			}
			else if(x == 5) {
				line += " " + conversion(binaryRuleNum.charAt(5));
			}
			else {
				line += " " + conversion(binaryRuleNum.charAt(x));
			}
		}
		return line;
		
	}
}
