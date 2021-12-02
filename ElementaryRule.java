
public class ElementaryRule extends Rule {

	int allSubRules = 8;
	private String binaryRuleNum;

	public ElementaryRule(int ruleNum) throws InvalidRuleNumException {
		super(ruleNum);

		if (ruleNum > 255 || ruleNum < 0) {
			throw new InvalidRuleNumException();
		} else {
			this.binaryRuleNum = ruleToBinary(ruleNum);
		}
	}

	public int getNumSubrules() {
		return allSubRules;
	}

	public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {

		Cell[] neigh = new Cell[3];

		neigh[0] = bc.getNeighbor(cellIdx, -1, gen);
		neigh[1] = bc.getNeighbor(cellIdx, 0, gen);
		neigh[2] = bc.getNeighbor(cellIdx, 1, gen);
		return neigh;

	}

	private char conversion(char x) {
		if (x == '0')
			return '.';

		else
			return 'O';

	}

	public EvolvedCell evolve(Cell[] neighborhood) {
		String binaryNeigh = "";

		for (int x = 0; x < neighborhood.length; x++) {

			if (neighborhood[x].toString().equals(".")) {
				binaryNeigh += "0";
			} else if (neighborhood[x].toString().equals("O")) {
				binaryNeigh += "1";
			}
		}
		int subRuleNum = Integer.parseInt(binaryNeigh, 2);

		char subRuleChar;
		subRuleChar = binaryRuleNum.charAt(7 - subRuleNum);
		CellState state;

		if (subRuleChar == '1') {
			state = CellState.ON;
		} else {
			state = CellState.OFF;
		}

		EvolvedCell cellsEvolved = new EvolvedCell(state, subRuleNum);
		return cellsEvolved;

	}

	public String toString() {
		String line = "OOO OO. O.O O.. .OO .O. ..O ...\n";

		for (int x = 0; x < 8; x++) {

			if (x == 0) {
				line += " " + conversion(binaryRuleNum.charAt(0));
			} else if (x == 7) {
				line += "   " + conversion(binaryRuleNum.charAt(7)) + " ";
			} else {
				line += "   " + conversion(binaryRuleNum.charAt(x));
			}
		}
		return line;
	}

	private String ruleToBinary(int ruleNum) {
		String stringRule = Integer.toBinaryString(ruleNum);

		while (stringRule.length() < 8) {
			stringRule = "0" + stringRule;
		}

		return stringRule;
	}

}
