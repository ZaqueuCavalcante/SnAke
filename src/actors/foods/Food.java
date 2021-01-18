package actors.foods;

import actors.nodes.Node;
import basis.Position;

public class Food extends Node {

    public Food() {}

    public Food(int row, int column) {
        super(row, column);
    }

    public int nutritionalValue() {
        return 1;
    }

    public void moveTo(Position position) {
        this.row = position.row();
        this.column = position.column();
    }

}
