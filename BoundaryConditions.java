
public interface BoundaryConditions {

	Cell getNeighbor(int cellIdx, int offset, Generation gen);
	
}
