package actors.nodes;

import java.awt.Color;

public class Node {

    private static final int size = 50;
    private static final int borderRadius = 5;

    private int row;
    private int column;
    private short direction;

    private Node[] neighbors;

    protected Color color;

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void pointToFront() {
        direction = 0;
    }
    public void pointToRight() {
        direction = 1;
    }
    public void pointToBack() {
        direction = 2;
    }
    public void pointToLeft() {
        direction = 3;
    }

    public int row() {
        return row;
    }
    public int column() {
        return column;
    }

    public int size() {
        return size;
    }

    public Color color() {
        return color;
    }

    @Override
    public int hashCode() {
        return (int) Math.random() * 1000;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj.getClass() != this.getClass())
            return false;
        
        final Node other = (Node) obj;
        if (this.row != other.row)
            return false;

        if (this.column != other.column)
            return false;
        
        return true;
    }

}
