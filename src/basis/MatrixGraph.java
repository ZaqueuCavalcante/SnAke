package basis;

import java.util.ArrayList;
import java.util.List;

import actors.foods.Food;
import actors.nodes.BorderNode;
import actors.nodes.FloorNode;
import actors.nodes.Node;
import actors.snakes.BodyNode;
import actors.snakes.Snake;

public class MatrixGraph {

    private int rows;
    private int columns;

    private Node[][] nodes;

    private List<Position> freePositions = new ArrayList<>();

    public MatrixGraph(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        nodes = new Node[rows][columns];
        surround();
        fillInside();
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void insert(Node node) {
        nodes[node.row()][node.column()] = node;
    }

    public void insert(List<BodyNode> nodes) {
        for (BodyNode node : nodes)
            insert(node);
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private void surround() {
        surroundRow(0);
        surroundRow(rows - 1);
        surroundColumn(0);
        surroundColumn(columns - 1);
    }

    private void surroundRow(int row) {
        for (int column = 0; column < columns; column++) {
            insert(new BorderNode(row, column));
        }
    }

    private void surroundColumn(int column) {
        for (int row = 1; row < rows; row++) {
            insert(new BorderNode(row, column));
        }
    }

    private void fillInside() {
        for (int row = 1; row < rows - 1; row++) {
            for (int column = 1; column < columns - 1; column++) {
                insert(new FloorNode(row, column));
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

    public void shake() {
        for (int row = 1; row < rows - 1; row++) {
            for (int column = 1; column < columns - 1; column++) {
                insert(nodeAt(row, column).move());
            }
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private Position getRandomFreePosition() {
        freePositions.clear();
        for (int row = 1; row < rows -1 ; row++) {
            for (int column = 1; column < columns - 1; column++) {
                if (nodeAt(row, column) instanceof FloorNode)
                    freePositions.add(new Position(row, column));
            }
        }
        int randomIndex = (int) (Math.random() * freePositions.size());
        return freePositions.get(randomIndex);
    }

    public void put(Food food) {
        Position position = getRandomFreePosition();
        food.moveTo(position.row(), position.column());
        insert(food);
    }

    public void put(Snake snake) {
        snake.moveHeadTo(rows/2, columns/2);
        insert(snake.head());
        insert(snake.body());
    }

}
