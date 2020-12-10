package controllers;

import java.util.ArrayList;
import java.util.List;

import actors.foods.Food;
import actors.snakes.Snake;
import basis.MatrixGraph;
import basis.Position;

public class Positioner {

    private final List<Position> freePositions = new ArrayList<Position>();
    
    public Positioner() {}

    public void put(Food food, MatrixGraph matrixGraph) {
        freePositions.clear();
        for (int row = 1; row < matrixGraph.rows() -1 ; row++) {
            for (int column = 1; column < matrixGraph.columns() - 1; column++) {
                if (matrixGraph.containsAFloorNodeAt(row, column))
                    freePositions.add(new Position(row, column));
            }
        }
        int randomIndex = (int) (Math.random() * freePositions.size());
        Position position = freePositions.get(randomIndex);
        food.moveTo(position.row(), position.column());
        matrixGraph.insert(food, position.row(), position.column());
    }

    public void put(Snake snake, MatrixGraph matrixGraph) {
        int row = (int) (matrixGraph.rows() / 2);
        int column = (int) (matrixGraph.columns() / 2);
        snake.moveHeadTo(row, column);
        matrixGraph.insert(snake.head(), row, column);
        matrixGraph.insert(snake.body().get(0), row + 1, column);
    }
    
}
