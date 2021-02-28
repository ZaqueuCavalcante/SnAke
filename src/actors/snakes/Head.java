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

    public void moveTo(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int nextRow() {
        return this.row + (int) Math.sin(this.angle);
    }

    public int nextColumn() {
        return this.column + (int) Math.cos(this.angle);
    }
    
}
