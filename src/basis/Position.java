package basis;

public class Position {

    private int row;
    private int column;

    public Position(int row, int column) {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException("Row and column must be positive values.");
        }
        this.row = row;
        this.column = column;
    }

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }

}
