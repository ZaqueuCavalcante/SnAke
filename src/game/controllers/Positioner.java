package controllers;

import java.util.HashSet;
import java.util.Set;

import actors.foods.Apple;
import actors.foods.Food;
import basis.MatrixGraph;
import basis.Position;

public class Positioner {

    private final Set<Position> freePositions = new HashSet<Position>();
    
    public Positioner() {}

    public void put(Food food, MatrixGraph matrixGraph) {
        freePositions.clear();
        for (int row = 1; row < matrixGraph.rows() -1 ; row++) {
            for (int column = 1; column < matrixGraph.columns() - 1; column++) {
                if (matrixGraph.containsAFloorNodeAt(row, column))
                    freePositions.add(new Position(row, column));
            }
        }
        Position p = freePositions.iterator().next();
        matrixGraph.insert(new Apple(p.row(), p.column()), p);
    }
    
}
