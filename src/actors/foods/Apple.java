package actors.foods;

import java.awt.Color;

public class Apple extends Food {

    public Apple() {
        color = Color.RED;
    }

    public Apple(int row, int column) {
        super(row, column);
        color = Color.RED;
    }

}
