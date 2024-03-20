package view.strategypattern;

// arbitrary interface name
public interface Strategy {
	// strategy method
	
	// arbitrary abstract method
	// important: list of parameters and return type -> ex: (x,y) -> x/y
	int process(int x, int y);
	
}
