class Noode {

    row: number;
    column: number;

    static size: number = 60;

    color: p5.Color = color('white');

    constructor(row: number, column: number) {
        this.row = row;
        this.column = column;
    }

    public draw() {
        stroke(this.color);
        rect(this.column*Noode.size, this.row*Noode.size, Noode.size, Noode.size, Noode.size/10);
        circle(this.column*Noode.size, this.row*Noode.size, Noode.size/10);
    }

}
