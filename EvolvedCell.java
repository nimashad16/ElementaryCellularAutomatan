
public class EvolvedCell extends Cell {

	private int subruleNum;
	
	public EvolvedCell(CellState state,int subruleNum) {
		super(state);
		this.subruleNum = subruleNum;
	}
	
	public int getSubruleNum() {
		return subruleNum;
	}
}
