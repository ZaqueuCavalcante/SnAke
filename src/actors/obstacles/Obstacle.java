package actors.obstacles;

import actors.nodes.Node;

public class Obstacle extends Node {

    public Obstacle() {}

	public Obstacle(int row, int column) {
		super(row, column);
    }
    
    public int damageValue() {
        return 1;
    }

}
