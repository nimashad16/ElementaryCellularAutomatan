
public class CircularBoundaryConditions implements BoundaryConditions {

	public CircularBoundaryConditions() {
	}

	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		
		int circleIdx = (offset % gen.size()) + cellIdx;
	
		 if(circleIdx >= gen.size()) {
				circleIdx = circleIdx - gen.size();
			}
		 
		else if(circleIdx < 0) {
			circleIdx = gen.size() + circleIdx;
		}
		
		return gen.getCell(circleIdx);
	}
}
