package actors.nodes;

import java.awt.Color;

public class Node {

    public static final int SIZE = 50;

    private int row;
    private int column;
    private double direction = -1;

    // private Node[] neighbors;

    protected Color color;

    public Node() {}

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void park() {
        direction = -1;
    }
    public boolean isNotParked() {
        return direction >= 0.0;
    }

    public void pointToRight() {
        direction = 0.0;
    }
    public void pointToDown() {
        direction = Math.PI/2.0;
    }
    public void pointToLeft() {
        direction = Math.PI;
    }
    public void pointToUp() {
        direction = 1.5*Math.PI;
    }

    public void pointTo(Node otherNode) {
        if (otherNode.row() == this.row) {
            if (otherNode.column() == this.column + 1)
                pointToRight();
            else
                pointToLeft();
        }
        if (otherNode.column() == this.column) {
            if (otherNode.row() == this.row + 1)
                pointToDown();
            else
                pointToUp();
        }
    }

    public Node move() {
        if (direction == 0.0) column++;
        if (direction == Math.PI/2.0) row++;
        if (direction == Math.PI) column--;
        if (direction == 1.5*Math.PI) row--;
        return this;
    }

    public void moveTo(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public double xProj() {
        return Math.cos(direction)*SIZE/2.0;
    }
    public double yProj() {
        return Math.sin(direction)*SIZE/2.0;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public Color color() {
        return color;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public int row() {
        return row;
    }
    public int column() {
        return column;
    }

    // public int nextRow() {
    //     if (direction == 1) return row-1;
    //     if (direction == 3) return row+1;
    //     return row;
    // }

    // public int nextColumn() {
    //     if (direction == 2) return column+1;
    //     if (direction == 4) return column-1;
    //     return column;
    // }

}
