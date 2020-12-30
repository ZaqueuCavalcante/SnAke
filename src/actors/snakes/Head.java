package actors.snakes;

import java.awt.Color;

import actors.nodes.Node;

public class Head extends Node {

    public Head() {
        color = new Color(0, 100, 0);
    }

    public Head(int row, int column) {
        super(row, column);
        color = new Color(0, 100, 0);
    }
    
}
