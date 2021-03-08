package actors.nodes;

import java.awt.Color;

public class Node {

    public static final int SIZE = 50;

    protected int row;
    protected int column;
    protected double angle = -1;

    private Node[] neighbors;

    protected Color color;

    public Node() {}

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
        neighbors = new Node[4];
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void park() {
        angle = -1;
    }
    public boolean isNotParked() {
        return angle >= 0.0;
    }

    public void pointToRight() {
        angle = 0.0;
    }
    public void pointToDown() {
        angle = Math.PI/2.0;
    }
    public void pointToLeft() {
        angle = Math.PI;
    }
    public void pointToUp() {
        angle = 1.5*Math.PI;
    }

    public void pointTo(Node otherNode) {  // Mover pra Body Node?
        if (otherNode.row() == this.row) {
            if (otherNode.column() > this.column)
                pointToRight();
            else
                pointToLeft();
        }
        else {
            if (otherNode.row() > this.row)
                pointToDown();
            else
                pointToUp();
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public Node move() {
        if (angle == 0.0) column++;
        if (angle == Math.PI/2.0) row++;
        if (angle == Math.PI) column--;
        if (angle == 1.5*Math.PI) row--;
        return this;
    }

    public double angle() {
        return angle;
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

}
