package actors.snakes;

import java.awt.Color;
import actors.nodes.Node;

public class BodyNode extends Node {

    public BodyNode() {
        color = Color.GREEN;
    }

    public BodyNode(int row, int column) {
        super(row, column);
        color = Color.GREEN;
    }

    public void moveTo(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
}
