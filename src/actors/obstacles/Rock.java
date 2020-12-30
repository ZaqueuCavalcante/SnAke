package actors.obstacles;

public class Rock extends Obstacle {

    public Rock() {}

    public Rock(int row, int column) {
        super(row, column);
    }

    @Override
    public int damageValue() {
        return 5;
    }

}
