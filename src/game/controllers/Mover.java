package controllers;

import actors.nodes.FloorNode;
import actors.snakes.BodyNode;
import actors.snakes.Head;
import actors.snakes.Snake;
import basis.MatrixGraph;

public class Mover {

    public void move(Snake snake, MatrixGraph matrixGraph) {
        int pivo = snake.head().direction();
        Head snakeHead = snake.head();
        int headRow = snakeHead.row();
        int headColumn = snakeHead.column();

        snakeHead.move();
        matrixGraph.insert(snakeHead);

        BodyNode lastBodyNode = snake.body().get(snake.body().size() - 1);

        matrixGraph.insert(new FloorNode(lastBodyNode.row(), lastBodyNode.column()));

        lastBodyNode.moveTo(headRow, headColumn);
        matrixGraph.insert(lastBodyNode);
        snake.body().set(snake.body().size() - 1, snake.body().get(0));
        snake.body().set(0, lastBodyNode);
    }
    
}
