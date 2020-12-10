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
    void live() {
        dead = false;
    }
    void die() {
        dead = true;
    }
    
    boolean isDead() {
        return dead;
    }
    boolean isNotDead() {
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
    void eat(Food food) {
        score += food.nutritionalValue();
    }
    void getHurt(Obstacle obstacle) {
        score -= obstacle.damageValue();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public Head head() {
        return head;
    }

    public List<BodyNode> body() {
        return body;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    void addBodyNode() {}

    public void move() {
        int headRow = head.row();
        int headColumn = head.column();
        head.move();
        BodyNode lastBodyNode = body.get(body.size() - 1);
        lastBodyNode.moveTo(headRow, headColumn);
        body.set(body.size() - 1, body.get(0));
        body.set(0, lastBodyNode);
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
