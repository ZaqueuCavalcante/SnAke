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
    public static final int layers = 3;

    private Node[][][] nodes;

    private List<Position> freePositions = new ArrayList<>();

    public MatrixGraph(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        nodes = new Node[rows][columns][layers];
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void insert(Node node, int layer) {
        nodes[node.row()][node.column()][layer] = node;
    }

    public void remove(Node node, int layer) {
        nodes[node.row()][node.column()][layer] = null;
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
            insert(new BorderNode(row, column), 0);
        }
    }

    private void surroundColumn(int column) {
        for (int row = 1; row < rows-1; row++) {
            insert(new BorderNode(row, column), 0);
        }
    }

    public void fillInside() {
        for (int row = 1; row < rows-1; row++) {
            for (int column = 1; column < columns-1; column++) {
                insert(new FloorNode(row, column), 0);
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
    public Node nodeAt(int row, int column, int layer) {
        return nodes[row][column][layer];
    }

    // public void shake() {
    //     for (int row = 1; row < rows - 1; row++) {
    //         for (int column = 1; column < columns - 1; column++) {
    //             insert(nodeAt(row, column, 0).move(), 0);
    //         }
    //     }
    // }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private Position getRandomFreePosition() {
        freePositions.clear();
        for (int row = 1; row < rows -1 ; row++) {
            for (int column = 1; column < columns - 1; column++) {
                if (nodeAt(row, column, 1) == null && nodeAt(row, column, 2) == null)
                    freePositions.add(new Position(row, column));
            }
        }
        int randomIndex = (int) (Math.random() * freePositions.size());
        return freePositions.get(randomIndex);
    }

    public void put(Food food) {
        food.moveTo(getRandomFreePosition());
        insert(food, 1);
    }

    public void put(Snake snake) {
        snake.head().moveTo(rows/2, columns/2);
        insert(snake.head(), 2);
        snake.body().get(0).moveTo(snake.head().row()+1, snake.head().column());
        insert(snake.body().get(0), 2);
        snake.body().get(0).pointTo(snake.head());
    }

}
