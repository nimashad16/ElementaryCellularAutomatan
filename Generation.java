import java.util.Arrays;

public class Generation {

	private Cell[] cells;
	
	public Generation(CellState[] states) {
		cells = new Cell[states.length];
		for(int x =0; x < states.length;x++) {
			this.cells[x] = new Cell(states[x]);
		}
	}
	
	public Generation(String states) throws IllegalArgumentException {
		cells = new Cell[states.length()];
			
		for(int x = 0; x < states.length(); x++) {	
			char stateValue = states.charAt(x);
			
			if( stateValue != '.' && stateValue != 'O'){
			 throw new IllegalArgumentException();
			}
			CellState nextState = CellState.getState(stateValue);
			cells[x] = new Cell(nextState);
		}
	}
	

	public Generation(Cell[] cells) {
		this.cells = Arrays.copyOf(cells, cells.length);
		}
		

	
	public int size() {
		return cells.length;
		
	}
	
	public Cell getCell(int idx) {
		return cells[idx];
		
	}
	
	public String toString() {
		String line = "";
		
		for(int idx =0; idx < cells.length; idx++) {
		line = line + cells[idx].toString();
		}
		
		return line;
		
	}
}
