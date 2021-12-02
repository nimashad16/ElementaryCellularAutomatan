import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Driver {
	
	
	public static void main(String[] args) throws InvalidRuleNumException, InvalidStepNumException, IOException{
	
	ElementaryRule ruleNum = new ElementaryRule(90);
		
	Generation initGen = new Generation("..................................................O........"
			+ "..........................................");
	
	
	Generation secondInitGen = new Generation("..................................................O........"
			+ "..........................................");
	
	CircularBoundaryConditions cb = new CircularBoundaryConditions();
	FixedBoundaryConditions fb = new FixedBoundaryConditions(CellState.OFF, CellState.OFF);
	
	Automaton automaton = new Automaton(ruleNum , initGen, cb);
	Automaton secondAutomaton = new Automaton(ruleNum, secondInitGen, fb);
	
	BufferedWriter tufferedWriter = new BufferedWriter(new FileWriter("subrules-elementary90-circularbc.csv"));
	automaton.evolve(100);
	secondAutomaton.evolve(100);
	
	
	int[][] circularHamming = AutomatonMeasurements.subruleCounts(automaton);
	
	for(int x =0; x < circularHamming.length;x++) {
		for(int i =0; i < circularHamming[0].length;i++) {
			if(i == circularHamming[0].length) {
				System.out.println(circularHamming[x][i]);
				}
				else {
					System.out.println(circularHamming[x][i] + ",");
				}
			
			}
		System.out.println("\n");
	
	}
	tufferedWriter.close();
	}
	
	
} 
