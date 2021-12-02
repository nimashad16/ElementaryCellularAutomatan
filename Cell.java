
public class Cell {

	private CellState state;
	
	public Cell() {
	 this.state =  CellState.OFF;
	}
	
	public Cell(CellState state) {
		this.state = state;
	}
	
	public CellState getState() {
		return state;	
	}
	
	public String toString() {
		return state.toString();
		
	}
	
	
}
