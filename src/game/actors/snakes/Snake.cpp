#include "Snake.h"

Snake::Snake() {}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
void Snake::live() {
    this->dead = false;
}
void Snake::die() {
    this->dead = true;
}
bool Snake::isDead() {
    return this->dead;
}
bool Snake::isNotDead() {
    return !this->dead;
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
void Snake::resetScore() {
    this->score = 0;
}
void Snake::increaseScore(Food food) {
    this->score += food.getXp();  // Polimorfismo. Declarar m�todo como virtual?
}
void Snake::decreaseScore(Obstacle obstacle) {
    this->score -= obstacle.getXPDamage();  // Polimorfismo. Declarar m�todo como virtual?
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
void Snake::eat(Food food) {

}

void Snake::addBodyNode() {

}

void Snake::move() {

}

Node Snake::getNextNode() {
    // return *(this->head->getNextNodePointer());
}
