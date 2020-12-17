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
    public short direction() {
        return direction;
    }
    public void pointToNothing() {
        direction = 0;
    }
    public void pointToUp() {
        direction = 1;
    }
    public void pointToRight() {
        direction = 2;
    }
    public void pointToDown() {
        direction = 3;
    }
    public void pointToLeft() {
        direction = 4;
    }

    public void pointTo(short direction) {
        if (direction < 0 || direction > 4) {
            throw new IllegalArgumentException("Direção inválida.");
        }
        this.direction = direction;
    }

    public Node move() {
        if (direction == 1) row--;
        if (direction == 2) column++;
        if (direction == 3) row++;
        if (direction == 4) column--;
        return this;
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
    public static int size() {
        return size;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public Color color() {
        return color;
    }

    public int nextRow() {
        if (direction == 1) return row-1;
        if (direction == 3) return row+1;
        return row;
    }

    public int nextColumn() {
        if (direction == 2) return column+1;
        if (direction == 4) return column-1;
        return column;
    }

}
