class Graph {

    private rows: number;
    private columns: number;

    private nodes: Noode[][];

    constructor(rows: number, columns: number) {
        this.rows = rows;
        this.columns = columns;
        this.fill();
    }
    
    private insert(node: Noode) {
        this.nodes[node.row][node.column] = node;
    }

    private fill() {
        this.nodes = [];
        for (let row = 0; row < this.rows; row++) {
            this.nodes[row] = [];
            for (let column = 0; column < this.columns; column++) {
                this.insert(new Noode(row, column));
            }
        }
    }

    public draw() {
        for (let row = 0; row < this.rows; row++) {
            for (let column = 0; column < this.columns; column++) {
                this.nodes[row][column].draw();
            }
        }
    }










    // public Node nodeAt(int row, int column) {
    //     return nodes[row][column];
    // }

    // // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // private Position getRandomFreePosition() {
    //     List<Position> freePositions = new ArrayList<>();
    //     for (int row = 1; row < rows -1 ; row++) {
    //         for (int column = 1; column < columns - 1; column++) {
    //             if (nodeAt(row, column) instanceof FloorNode)
    //                 freePositions.add(new Position(row, column));
    //         }
    //     }
    //     int randomIndex = (int) (Math.random() * freePositions.size());
    //     return freePositions.get(randomIndex);
    // }

    // public void put(Food food) {
    //     food.moveTo(getRandomFreePosition());
    //     insert(food);
    // }

    // public void put(Snake snake) {
    //     int centerRow = rows/2;
    //     int centerColumn = columns/2;
    //     snake.head().moveTo(centerRow, centerColumn);
    //     insert(snake.head());
    //     snake.body().get(0).moveTo(centerRow+1, centerColumn);
    //     insert(snake.body().get(0));

    //     snake.body().get(1).moveTo(centerRow+2, centerColumn);
    //     insert(snake.body().get(1));

    //     snake.body().get(2).moveTo(centerRow+3, centerColumn);
    //     insert(snake.body().get(2));
    // }

    // public void move(Node node) {
    //     insert(new FloorNode(node.row(), node.column()));
    //     node.move();
    //     insert(node);
    // }
}
