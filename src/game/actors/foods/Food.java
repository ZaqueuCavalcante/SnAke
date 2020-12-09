package actors.foods;

import actors.nodes.Node;

public class Food extends Node {

    public Food(int row, int column) {
        super(row, column);
    }

    public int nutritionalValue() {
        return 1;
    }

}
