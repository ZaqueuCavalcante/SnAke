package basis;

import actors.nodes.BorderNode;
import actors.nodes.FloorNode;
import actors.nodes.Node;

public class MatrixGraph {

    private int rows;
    private int columns;
    private static final short FENCE = 2;

    private Node[][] nodes;

    public MatrixGraph(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        nodes = new Node[rows + FENCE][columns + FENCE];
        surround(new BorderNode());
        fillInside(new FloorNode());
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private void insert(Node node, int row, int column) {
        nodes[row][column] = node;
    }

    private void surround(Node node) {
        fillRowWith(0, node);
        fillRowWith(rows + FENCE, node);
        fillColumnWith(0, node);
        fillColumnWith(columns + FENCE, node);
    }

    private void fillRowWith(int row, Node node) {
        for (int column = 0; column < columns + FENCE; column++) {
            insert(node, row, column);
        }
    }

    private void fillColumnWith(int column, Node node) {
        for (int row = 0; row < rows + FENCE; row++) {
            insert(node, row, column);
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private void fillInside(Node node) {
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                insert(node, row, column);
            }
        }
    }

}
