package actors.snakes;

import java.util.ArrayList;
import java.util.List;

import actors.foods.Food;
import actors.nodes.BorderNode;
import actors.obstacles.Obstacle;
import actors.portals.Portal;
import basis.MatrixGraph;

public class Snake {

    private Head head;
    private List<BodyNode> body;

    private int score;

    private boolean dead;

    public Snake() {
        head = new Head();
        head.pointToUp();
        body = new ArrayList<>();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void live() {
        dead = false;
    }
    public void die() {
        dead = true;
    }
    
    public boolean isDead() {
        return dead;
    }
    public boolean isNotDead() {
        return !dead;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public int score() {
        return score;
    }

    void resetScore() {
        score = 0;
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void eat(Food food) {
        score += food.nutritionalValue();
        for (int i = 0; i < food.nutritionalValue(); i++) {
            addBodyNode();
        }
    }
    public void getHurt(Obstacle obstacle) {
        score -= obstacle.damageValue();
        if (score < 0) dead = true;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public Head head() {
        return head;
    }

    public List<BodyNode> body() {
        return body;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    void addBodyNode() {
        body.add(new BodyNode(head.row(), head.column()));
    }

    public void updateDirections() {
        short pivo = head.direction();
        for (BodyNode bn : body) {
            bn.pointTo(pivo);
            pivo = bn.direction();
        }
    }

    public void moveHeadTo(int row, int column) {
        head.moveTo(row, column);
        body.add(new BodyNode(row + 1, column));
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private int nextRow() {
        return head.nextRow();
    }

    private int nextColumn() {
        return head.nextColumn();
    }

    public boolean foodCollide(MatrixGraph matrixGraph) {
        return matrixGraph.nodeAt(nextRow(), nextColumn()) instanceof Food;
    }
    
    public boolean selfCollide(MatrixGraph matrixGraph) {
        return matrixGraph.nodeAt(nextRow(), nextColumn()) instanceof BodyNode;
    }

    public boolean wallCollide(MatrixGraph matrixGraph) {
        return matrixGraph.nodeAt(nextRow(), nextColumn()) instanceof BorderNode;
    }

    public boolean obstacleCollide(MatrixGraph matrixGraph) {
        return matrixGraph.nodeAt(nextRow(), nextColumn()) instanceof Obstacle;
    }

    public boolean portalCollide(MatrixGraph matrixGraph) {
        return matrixGraph.nodeAt(nextRow(), nextColumn()) instanceof Portal;
    }

}
