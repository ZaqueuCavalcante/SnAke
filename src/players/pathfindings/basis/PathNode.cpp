#include "PathNode.h"
#include <stdlib.h>

PathNode::PathNode(int row, int column) {
    this->row = row;
    this->column = column;
}

PathNode::~PathNode() {}

int PathNode::getRow() {
    return this->row;
}

int PathNode::getColumn() {
    return this->column;
}

int PathNode::getG() {
    return this->G;
}

int PathNode::getTotalCost() {
    return (this->G + this->H);
}

int PathNode::getDistanceTo(PathNode* node) {
    int deltaRow = abs(node->getRow() - this->row);
    int deltaColumn = abs(node->getColumn() - this->column);
    return (deltaRow + deltaColumn);
}

void PathNode::setDistanceToStartNode(PathNode* previousNode) {
    this->G = previousNode->getG() + this->getDistanceTo(previousNode);
}

void PathNode::setDistanceToGoalNode(PathNode* goalNode) {
    this->H = this->getDistanceTo(goalNode);
}
