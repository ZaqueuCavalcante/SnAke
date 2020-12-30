package actors.obstacles;

public class Shrub extends Obstacle {

    public Shrub() {}

    public Shrub(int row, int column) {
        super(row, column);
    }

    @Override
    public int damageValue() {
        return 3;
    }

}
