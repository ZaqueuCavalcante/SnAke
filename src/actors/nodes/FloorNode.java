package actors.nodes;

import java.awt.Color;

public class FloorNode extends Node {

    public FloorNode() {
        color = Color.LIGHT_GRAY;
    }

    public FloorNode(int row, int column) {
        super(row, column);
        color = Color.LIGHT_GRAY;
    }

}
