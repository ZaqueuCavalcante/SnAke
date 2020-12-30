package graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import actors.foods.Apple;
import actors.foods.Food;
import actors.nodes.Node;
import actors.snakes.Snake;
import basis.MatrixGraph;
import controllers.Mover;
import controllers.Positioner;

public class MyJPanel extends JPanel implements ActionListener {

    static final long serialVersionUID = 1L;

    static final int WIDTH = 1200;
    static final int HEIGHT = 800;

    static final int DELAY = 200;

    Timer timer;

    MatrixGraph matrixGraph = new MatrixGraph(16, 24);
    Positioner positioner = new Positioner();
    Snake snake = new Snake();

    Mover mover = new Mover();

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
        
        positioner.put(snake, matrixGraph);
        positioner.put(new Apple(), matrixGraph);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        if (snake.foodCollide(matrixGraph)) {
            Food food = (Food) matrixGraph.nodeAt(snake.head().nextRow(), snake.head().nextColumn());
            snake.eat(food);
            positioner.put(new Apple(), matrixGraph);
        }
        if (snake.wallCollide(matrixGraph)) {
            snake.die();
            timer.stop();
            System.err.println("YOU LOST");
        }

        snake.updateDirections();

        matrixGraph.shake();
        
        show(matrixGraph, graphics);
        showGrid(matrixGraph, graphics);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void show(Node node, Graphics graphics) {
        graphics.setColor(node.color());
        int nodeSize = Node.size();
        int x = node.column() * nodeSize;
        int y = node.row() * nodeSize;
        graphics.fillRect(x, y, nodeSize, nodeSize);
    }

    public void show(MatrixGraph matrixGraph, Graphics graphics) {
        for (int row = 0; row < matrixGraph.rows(); row++) {
            for (int column = 0; column < matrixGraph.columns(); column++) {
                show(matrixGraph.nodeAt(row, column), graphics);
            }
        }
    }

    public void showGrid(MatrixGraph matrixGraph, Graphics graphics) {
        graphics.setColor(Color.WHITE);
        for (int i = 0; i < matrixGraph.columns(); i++)
            graphics.drawLine(i * Node.size(), 0, i * Node.size(), WIDTH);
        for (int i = 0; i < matrixGraph.rows(); i++)
            graphics.drawLine(0, i * Node.size(), WIDTH, i * Node.size());
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

                default:
            }
        }
    }

}
