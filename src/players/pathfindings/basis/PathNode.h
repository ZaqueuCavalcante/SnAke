#ifndef PATHNODE_H
#define PATHNODE_H

#include <list>

class PathNode {
    public:
        PathNode(int row, int column);
        ~PathNode();

        int getRow();
        int getColumn();

        int getG();
        int getTotalCost();

        int getDistanceTo(PathNode* node);
        void setDistanceToStartNode(PathNode* previousNode);
        void setDistanceToGoalNode(PathNode* goalNode);

    private:
        int row = 0;
        int column = 0;
        int G = 0;  // Distance to Start Node
        int H = 0;  // Distance to Goal Node

        PathNode* parent;
        std::list<PathNode*> neighbours;
};

#endif
