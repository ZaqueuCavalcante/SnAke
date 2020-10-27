package game.actors.nodes;

import game.basis.Position;

public class Node {

    private static final int size = 42;
    private static final int borderRadius = 10;

    private Position position;
    private short direction;

    private Node[] neighbors;

    public Node() {

    }

    public void pointToFront() {
        direction = 0;
    }
    public void pointToRight() {
        direction = 1;
    }
    public void pointToBack() {
        direction = 2;
    }
    public void pointToLeft() {
        direction = 3;
    }

}
