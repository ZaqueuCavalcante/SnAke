var ColorHelper = (function () {
    function ColorHelper() {
    }
    ColorHelper.getColorVector = function (c) {
        return createVector(red(c), green(c), blue(c));
    };
    ColorHelper.rainbowColorBase = function () {
        return [
            color('red'),
            color('orange'),
            color('yellow'),
            color('green'),
            color(38, 58, 150),
            color('indigo'),
            color('violet')
        ];
    };
    ColorHelper.getColorsArray = function (total, baseColorArray) {
        var _this = this;
        if (baseColorArray === void 0) { baseColorArray = null; }
        if (baseColorArray == null) {
            baseColorArray = ColorHelper.rainbowColorBase();
        }
        var rainbowColors = baseColorArray.map(function (x) { return _this.getColorVector(x); });
        ;
        var colours = new Array();
        for (var i = 0; i < total; i++) {
            var colorPosition = i / total;
            var scaledColorPosition = colorPosition * (rainbowColors.length - 1);
            var colorIndex = Math.floor(scaledColorPosition);
            var colorPercentage = scaledColorPosition - colorIndex;
            var nameColor = this.getColorByPercentage(rainbowColors[colorIndex], rainbowColors[colorIndex + 1], colorPercentage);
            colours.push(color(nameColor.x, nameColor.y, nameColor.z));
        }
        return colours;
    };
    ColorHelper.getColorByPercentage = function (firstColor, secondColor, percentage) {
        var firstColorCopy = firstColor.copy();
        var secondColorCopy = secondColor.copy();
        var deltaColor = secondColorCopy.sub(firstColorCopy);
        var scaledDeltaColor = deltaColor.mult(percentage);
        return firstColorCopy.add(scaledDeltaColor);
    };
    return ColorHelper;
}());
var Graph = (function () {
    function Graph(rows, columns) {
        this.rows = rows;
        this.columns = columns;
        this.fill();
    }
    Graph.prototype.insert = function (node) {
        this.nodes[node.row][node.column] = node;
    };
    Graph.prototype.fill = function () {
        this.nodes = [];
        for (var row = 0; row < this.rows; row++) {
            this.nodes[row] = [];
            for (var column = 0; column < this.columns; column++) {
                this.insert(new Noode(row, column));
            }
        }
    };
    Graph.prototype.draw = function () {
        for (var row = 0; row < this.rows; row++) {
            for (var column = 0; column < this.columns; column++) {
                this.nodes[row][column].draw();
            }
        }
    };
    return Graph;
}());
var Noode = (function () {
    function Noode(row, column) {
        this.color = color('white');
        this.row = row;
        this.column = column;
    }
    Noode.prototype.draw = function () {
        stroke(this.color);
        rect(this.column * Noode.size, this.row * Noode.size, Noode.size, Noode.size, Noode.size / 10);
        circle(this.column * Noode.size, this.row * Noode.size, Noode.size / 10);
    };
    Noode.size = 60;
    return Noode;
}());
var PolygonHelper = (function () {
    function PolygonHelper() {
    }
    PolygonHelper.draw = function (numberOfSides, width) {
        push();
        var angle = TWO_PI / numberOfSides;
        var radius = width / 2;
        beginShape();
        for (var a = 0; a < TWO_PI; a += angle) {
            var sx = cos(a) * radius;
            var sy = sin(a) * radius;
            vertex(sx, sy);
        }
        endShape(CLOSE);
        pop();
    };
    return PolygonHelper;
}());
var numberOfShapesControl;
var originCoords;
var graph;
function setup() {
    createCanvas(windowWidth, windowHeight);
    rectMode(CENTER).noFill().frameRate(60);
    originCoords = createVector(100, 100);
    graph = new Graph(5, 5);
}
function draw() {
    background(0);
    translate(originCoords.x, originCoords.y);
    strokeWeight(2);
    graph.draw();
}
function windowResized() {
    resizeCanvas(windowWidth, windowHeight);
}
//# sourceMappingURL=../sketch/sketch/build.js.map