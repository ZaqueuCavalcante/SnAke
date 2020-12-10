package actors.nodes;

import java.awt.Color;

public class BorderNode extends Node {

    public BorderNode() {
        color = Color.GRAY;
    }

    public BorderNode(int row, int column) {
        super(row, column);
        color = Color.GRAY;
    }

}