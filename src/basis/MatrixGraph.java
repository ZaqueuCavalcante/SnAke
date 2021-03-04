package basis;

import java.util.ArrayList;
import java.util.List;

import actors.foods.Food;
import actors.nodes.BorderNode;
import actors.nodes.FloorNode;
import actors.nodes.Node;
import actors.snakes.Head;
import actors.snakes.Snake;

public class MatrixGraph {

    private final int rows;
    private final int columns;

    private Node[][] nodes;

    public MatrixGraph(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        nodes = new Node[rows][columns];
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void insert(Node node) {
        nodes[node.row()][node.column()] = node;
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void surround() {
        surroundRow(0);
        surroundRow(rows - 1);
        surroundColumn(0);
        surroundColumn(columns - 1);
    }

    private void surroundRow(int row) {
        for (int column = 0; column < columns; column++) {
            BorderNode bn = new BorderNode(row, column);
            bn.number = column;
            insert(bn);
        }
    }

    private void surroundColumn(int column) {
        for (int row = 1; row < rows-1; row++) {
            BorderNode bn = new BorderNode(row, column);
            bn.number = row;
            insert(bn);
        }
    }

    public void fillInside() {
        for (int row = 1; row < rows-1; row++) {
            for (int column = 1; column < columns-1; column++) {
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

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private Position getRandomFreePosition() {
        List<Position> freePositions = new ArrayList<>();
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
        food.moveTo(getRandomFreePosition());
        insert(food);
    }

    public void put(Snake snake) {
        int centerRow = rows/2;
        int centerColumn = columns/2;
        snake.head().moveTo(centerRow, centerColumn);
        insert(snake.head());
        snake.body().get(0).moveTo(centerRow+1, centerColumn);
        insert(snake.body().get(0));

        snake.body().get(1).moveTo(centerRow+2, centerColumn);
        insert(snake.body().get(1));

        snake.body().get(2).moveTo(centerRow+3, centerColumn);
        insert(snake.body().get(2));
    }

    public void move(Node node) {
        insert(new FloorNode(node.row(), node.column()));
        node.move();
        insert(node);
    }

}
