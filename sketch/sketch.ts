let numberOfShapesControl: p5.Element;

let originCoords: p5.Vector;

let graph: Graph;

function setup() {
  createCanvas(windowWidth, windowHeight)
  rectMode(CENTER).noFill().frameRate(60);

  originCoords = createVector(100, 100);

  graph = new Graph(5, 5);

  // numberOfShapesControl = createSlider(1, 20, 15, 1).position(50, 50).style("width", "250px");
}

function draw() {
  background(0);
  
  translate(originCoords.x, originCoords.y);

  strokeWeight(2);

  graph.draw();

  
  // const numberOfShapes = <number>numberOfShapesControl.value();
  // const colours = ColorHelper.getColorsArray(numberOfShapes);
  
  // // CONSISTENT SPEED REGARDLESS OF FRAMERATE
  // const speed = (frameCount / (numberOfShapes * 30)) * 2;
  
  // // DRAW ALL SHAPES
  // for (var i = 0; i < numberOfShapes; i++) {
  //   push();
  //   const lineWidth = 4;
  //   const spin = speed * (numberOfShapes - i);
  //   const numberOfSides = 3 + i;
  //   const width = 30 * i;
  //   strokeWeight(lineWidth); 
  //   stroke(colours[i]);
  //   rotate(spin);
  //   PolygonHelper.draw(numberOfSides, width)
  //   pop();
  // }
}

function windowResized() {
  resizeCanvas(windowWidth, windowHeight);
}
