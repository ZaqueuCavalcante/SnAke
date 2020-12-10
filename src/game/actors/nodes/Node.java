package actors.nodes;

import java.awt.Color;

public class Node {

    private static final int size = 50;

    private int row;
    private int column;
    private short direction;

    private Node[] neighbors;

    protected Color color;

    public Node() {}

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void pointToUp() {
        direction = 0;
    }
    public void pointToRight() {
        direction = 1;
    }
    public void pointToDown() {
        direction = 2;
    }
    public void pointToLeft() {
        direction = 3;
    }

    public void move() {
        if (direction == 0) row--;
        if (direction == 1) column++;
        if (direction == 2) row++;
        if (direction == 3) column--;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public int row() {
        return row;
    }
    public int column() {
        return column;
    }

    public void moveTo(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public int size() {
        return size;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public Color color() {
        return color;
    }

}
