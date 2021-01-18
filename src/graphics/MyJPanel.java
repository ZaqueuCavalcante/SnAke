package graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyEvent;

import actors.foods.Apple;
import actors.foods.Food;
import actors.nodes.BorderNode;
import actors.nodes.Node;
import actors.snakes.Snake;
import basis.MatrixGraph;

public class MyJPanel extends JPanel implements ActionListener {

    static final long serialVersionUID = 1L;

    static final int WIDTH = 1200;
    static final int HEIGHT = 800;

    static final int DELAY = 20;

    Timer timer;

    MatrixGraph graph = new MatrixGraph(16, 24);
    Node previousHeadNode;

    Apple apple = new Apple();
    Snake snake = new Snake();

    public MyJPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        startGame();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }

    public void startGame() {
        timer = new Timer(DELAY, this);
        timer.start();

        graph.surround();
        graph.fillInside();
        
        graph.put(snake);
        graph.put(apple);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        // Atualizar vetores velocidade


        // Checar colisões
        if (graph.nodeAt(snake.head().row(), snake.head().column(), 1) instanceof Food) {
            snake.eat(apple);
            graph.remove(apple, 1);
            graph.put(apple);
        }
        // System.out.println("Food ->" + apple.row() + " " + apple.column());
        // System.out.println("Head ->" + snake.head().row() + " " + snake.head().column());

        if (graph.nodeAt(snake.head().row(), snake.head().column(), 0) instanceof BorderNode) {
            snake.die();
            timer.stop();
            System.err.println("YOU LOST");
        }

        //snake.updateDirections();

        //graph.shake();
        
        show(graph, graphics);
        showGrid(graph, graphics);
        // System.out.println(snake.head().row() + " " + snake.head().column());
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void show(Node node, Graphics graphics) {
        graphics.setColor(node.color());
        int x = node.column() * Node.SIZE;
        int y = node.row() * Node.SIZE;
        graphics.fillRect(x, y, Node.SIZE, Node.SIZE);
        if (node.isNotParked()) {
            graphics.setColor(Color.BLACK);
            x += Node.SIZE/2; y += Node.SIZE/2;
            Polygon triangle = new Polygon();
            triangle.addPoint((int)(x + Math.cos(node.angle())*Node.SIZE/2.0), (int)(y + Math.sin(node.angle())*Node.SIZE/2.0));
            triangle.addPoint((int)(x + Math.cos(node.angle() + Math.PI/2.0)*Node.SIZE/2.0), (int)(y + Math.sin(node.angle() + Math.PI/2.0)*Node.SIZE/2.0));
            triangle.addPoint((int)(x + Math.cos(node.angle() - Math.PI/2.0)*Node.SIZE/2.0), (int)(y + Math.sin(node.angle() - Math.PI/2.0)*Node.SIZE/2.0));
            graphics.fillPolygon(triangle);
            graphics.drawPolygon(triangle);
        }
    }

    public void show(MatrixGraph graph, Graphics graphics) {
        for (int row = 0; row < graph.rows(); row++) {
            for (int column = 0; column < graph.columns(); column++) {
                for (int layer = 0; layer < MatrixGraph.layers; layer++) {
                    if (graph.nodeAt(row, column, layer) != null) 
                        show(graph.nodeAt(row, column, layer), graphics);
                }
            }
        }
    }

    public void showGrid(MatrixGraph graph, Graphics graphics) {
        graphics.setColor(Color.WHITE);
        for (int i = 0; i < graph.columns(); i++)
            graphics.drawLine(i * Node.SIZE, 0, i * Node.SIZE, WIDTH);
        for (int i = 0; i < graph.rows(); i++)
            graphics.drawLine(0, i * Node.SIZE, WIDTH, i * Node.SIZE);
    }

    // public void showScore(Graphics graphics) {
    //     graphics.setColor(Color.red);
    //     graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
    //     FontMetrics metrics = getFontMetrics(graphics.getFont());
    //     graphics.drawString("Score: " + eatenApples, (WIDTH - metrics.stringWidth("Score: " + eatenApples)) / 2,
    //             graphics.getFont().getSize());
    // }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    snake.head().pointToLeft();
                    break;

                case KeyEvent.VK_RIGHT:
                    snake.head().pointToRight();
                    break;

                case KeyEvent.VK_UP:
                    snake.head().pointToUp();
                    break;

                case KeyEvent.VK_DOWN:
                    snake.head().pointToDown();
                    break;

                case KeyEvent.VK_SPACE:
                    Node frontNode = snake.head();
                    Node backNode = snake.body().get(0);

                    backNode.pointTo(frontNode);
                    frontNode.move();
                    graph.insert(frontNode, 2);
                    backNode.move();
                    graph.insert(backNode, 2);
                    backNode.pointTo(frontNode);

                    frontNode = backNode;

                    if (snake.body().size() > 1) {
                        for (int i = 1; i < snake.body().size(); i++) {
                            backNode = snake.body().get(i);

                            backNode.pointTo(frontNode);
                            frontNode.move();
                            graph.insert(frontNode, 2);
                            backNode.move();
                            graph.insert(backNode, 2);
                            backNode.pointTo(frontNode);

                            frontNode = backNode;
                        }
                    }
                    break;

                default:
            }
        }
    }

}
