package actors.snakes;

import java.util.ArrayList;
import java.util.List;

import actors.foods.Food;
import actors.obstacles.Obstacle;

public class Snake {

    private Head head;
    private List<BodyNode> body;

    private int score;

    private boolean dead;

    public Snake() {
        head = new Head();
        head.pointToUp();
        body = new ArrayList<>();
        body.add(new BodyNode());
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
        int index = body.size()-1;
        body.add(new BodyNode(body.get(index).row(), body.get(index).column()));
    }

    // public void updateDirections() {
    //     Node pivo = head;
    //     for (BodyNode bn : body) {
    //         bn.pointTo(pivo);
    //         pivo = bn;
    //     }
    // }

    // public void moveHeadTo(int row, int column) {
    //     head.moveTo(row, column);
    //     body.add(new BodyNode(row + 1, column));
    // }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    
    // public boolean selfCollide(MatrixGraph matrixGraph) {
    //     return matrixGraph.nodeAt(nextRow(), nextColumn()) instanceof BodyNode;
    // }

    // public boolean wallCollide(MatrixGraph matrixGraph) {
    //     return matrixGraph.nodeAt(nextRow(), nextColumn()) instanceof BorderNode;
    // }

    // public boolean obstacleCollide(MatrixGraph matrixGraph) {
    //     return matrixGraph.nodeAt(nextRow(), nextColumn()) instanceof Obstacle;
    // }

    // public boolean portalCollide(MatrixGraph matrixGraph) {
    //     return matrixGraph.nodeAt(nextRow(), nextColumn()) instanceof Portal;
    // }

}
