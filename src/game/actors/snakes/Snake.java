package actors.snakes;

import java.util.List;

import actors.foods.Food;
import actors.obstacles.Obstacle;

public class Snake {

    private Head head;
    private List<BodyNode> body;

    private int score = 0;

    private boolean dead;

    public Snake() {}

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

    public int score() {
        return score;
    }

    void resetScore() {
        score = 0;
    }
    
    void eat(Food food) {
        score += food.nutritionalValue();
    }
    void getHurt(Obstacle obstacle) {
        score -= obstacle.damageValue();
    }

    void addBodyNode() {}
    void move() {}

    //Node getNextNode() {}

}
