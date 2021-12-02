import java.util.HashMap;
import java.util.Map;

public enum CellState {

	OFF('.'), ON('O');
	
	private char symbol;
	private static Map<Character,CellState> SYMBOL_TO_STATE;
	
	static {
		SYMBOL_TO_STATE = new HashMap<>();
		SYMBOL_TO_STATE.put('.', CellState.OFF);
		SYMBOL_TO_STATE.put('O', CellState.ON);
		
	}
	private CellState(char symbol) {
		this.symbol = symbol;
	}
	
	public static CellState getState(char symbol) {
		return SYMBOL_TO_STATE.get(symbol);
	}
	
	public String toString() {
		return String.valueOf(symbol);
	}
	
		
}
