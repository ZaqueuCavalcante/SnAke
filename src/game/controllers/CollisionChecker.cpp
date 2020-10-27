#include "CollisionChecker.h"

CollisionChecker::CollisionChecker() {}

bool CollisionChecker::foodCollide(Snake snake) {
    // return (Food* ptr = dynamic_cast<Food*>(&snake.getNextNode()))
    return false;
}

bool CollisionChecker::selfCollide(Snake snake) {
    return false;
}

bool CollisionChecker::wallCollide(Snake snake) {
    return false;
}

bool CollisionChecker::obstacleCollide(Snake snake) {
    return false;
}

bool CollisionChecker::portalCollide(Snake snake) {
    return false;
}
