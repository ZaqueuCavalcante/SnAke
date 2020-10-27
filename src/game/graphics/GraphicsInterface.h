#ifndef GRAPHICSINTERFACE_H
#define GRAPHICSINTERFACE_H

#include "FloorNode.h"
#include "BorderNode.h"
#include "Food.h"
#include "Obstacle.h"
#include "Portal.h"

#include "Head.h"
#include "BodyNode.h"
#include "Snake.h"

#include "MatrixGraph.h"

class GraphicsInterface {
    public:
        GraphicsInterface();

        virtual void show(FloorNode floorNode) const = 0;
        virtual void show(BorderNode borderNode) const = 0;
        virtual void show(Food food) const = 0;
        virtual void show(Obstacle obstacle) const = 0;
        virtual void show(Portal portal) const = 0;

        virtual void show(Head head) const = 0;
        virtual void show(BodyNode bodyNode) const = 0;
        virtual void show(Snake snake) const = 0;

        virtual void show(MatrixGraph matrixGraph) const = 0;
};

#endif
