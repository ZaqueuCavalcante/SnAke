package basis;

import actors.nodes.BorderNode;
import actors.nodes.FloorNode;
import actors.nodes.Node;

public class MatrixGraph {

    private int rows;
    private int columns;

    private Node[][] nodes;

    public MatrixGraph(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        nodes = new Node[rows][columns];
        surround();
        fillInside();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private void insert(Node node, int row, int column) {
        nodes[row][column] = node;
    }

    public void insert(Node node, Position position) {
        insert(node, position.row(), position.column());;
    }

    private void surround() {
        surroundRow(0);
        surroundRow(rows - 1);
        surroundColumn(0);
        surroundColumn(columns - 1);
    }

    private void surroundRow(int row) {
        for (int column = 0; column < columns; column++) {
            insert(new BorderNode(row, column), row, column);
        }
    }

    private void surroundColumn(int column) {
        for (int row = 1; row < rows; row++) {
            insert(new BorderNode(row, column), row, column);
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private void fillInside() {
        for (int row = 1; row < rows - 1; row++) {
            for (int column = 1; column < columns - 1; column++) {
                insert(new FloorNode(row, column), row, column);
            }
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public int rows() {
        return rows;
    }

    public int columns() {
        return columns;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public Node nodeAt(int row, int column) {
        return nodes[row][column];
    }

    public boolean containsAFloorNodeAt(int row, int column) {
        return nodeAt(row, column) instanceof FloorNode;
    }

}
