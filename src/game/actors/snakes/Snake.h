#ifndef SNAKE_H
#define SNAKE_H

#include "Head.h"
#include "BodyNode.h"
#include "Food.h"
#include "Obstacle.h"

class Snake {
    public:
        Snake();

        void live();
        void die();
        bool isDead();
        bool isNotDead();

        void resetScore();
        void increaseScore(Food food);
        void decreaseScore(Obstacle obstacle);

        void eat(Food food);
        void addBodyNode();
        void move();

        Node getNextNode();

    protected:
        Head head;
        // List<BodyNode> body;

        bool dead = false;

        int score = 0;

    private:
};

#endif
