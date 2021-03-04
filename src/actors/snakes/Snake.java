package actors.snakes;

import java.util.ArrayList;
import java.util.List;

import actors.foods.Food;
import actors.obstacles.Obstacle;

public class Snake {

    private Head head;
    private List<BodyNode> body;
    public int lastNodeIndex;

    private int score;

    private boolean dead;

    public Snake() {
        head = new Head();
        head.pointToUp();
        body = new ArrayList<>();
        body.add(new BodyNode());
        body.get(0).pointToUp();

        body.add(new BodyNode());
        body.get(1).pointToUp();

        body.add(new BodyNode());
        body.get(2).pointToUp();

        lastNodeIndex = 2;
        
        this.live();
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
            this.addBodyNode();
        }
    }

    public void getHurt(Obstacle obstacle) {
        score -= obstacle.damageValue();
        if (score < 0)
            this.die();
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
        BodyNode lastNode = body.get(body.size()-1);
        body.add(new BodyNode(lastNode.row(), lastNode.column()));
    }

}
