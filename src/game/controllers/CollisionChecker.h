#ifndef COLLISIONCHECKER_H
#define COLLISIONCHECKER_H

#include "Snake.h"

class CollisionChecker {
    public:
        CollisionChecker();

        bool foodCollide(Snake snake);
        bool selfCollide(Snake snake);
        bool wallCollide(Snake snake);
        bool obstacleCollide(Snake snake);
        bool portalCollide(Snake snake);

    protected:

    private:
};

#endif
