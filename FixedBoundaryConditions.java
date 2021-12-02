
public class FixedBoundaryConditions implements BoundaryConditions {

	private CellState left;
	private CellState right;
	
	public FixedBoundaryConditions( CellState left, CellState right){
		this.left = left;
		this.right = right;
		}
	
	public CellState getLeftState() {
		return left;	
	}
	
	public CellState getRightState(){
		return right;
	}
	
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		int neighborIdx;
		neighborIdx = cellIdx + offset;
		
		if(neighborIdx >= gen.size()) {
			return new Cell(right);
		}
		
		else if(neighborIdx < 0) {
			return new Cell(left);
		}
	
		return gen.getCell(neighborIdx);
	}
}
