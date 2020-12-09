package actors.foods;

import java.awt.Color;

public class Frog extends Food {

    public Frog(int row, int column) {
        super(row, column);
        color = Color.BLUE;
    }

    @Override
    public int nutritionalValue() {
        return 10;
    }

}
