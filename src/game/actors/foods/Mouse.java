package actors.foods;

import java.awt.Color;

public class Mouse extends Food {

    public Mouse(int row, int column) {
        super(row, column);
        color = Color.PINK;
    }

    @Override
    public int nutritionalValue() {
        return 5;
    }

}
