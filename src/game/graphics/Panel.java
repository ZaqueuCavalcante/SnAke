package graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.FontMetrics;

public class Panel extends JPanel implements ActionListener {

    static final long serialVersionUID = 1L;

    static final int WIDTH = 1200;
    static final int HEIGHT = 800;

    static final int UNIT_SIZE = 50;
    static final int GAME_UNITS = (WIDTH * HEIGHT) / UNIT_SIZE;

    static final int DELAY = 100;

    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];

    char direction = 'R'; // R, U, L, D.

    int bodyParts = 6;
    int eatenApples;

    int appleX;
    int appleY;

    boolean running = false;
    Timer timer;
    Random random;

    public Panel() {
        random = new Random();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (running) {
            showGrid(graphics);
            showApple(graphics);
            showSnake(graphics);
            showScore(graphics);
        }
        else {
            gameOver(graphics);
        }
    }

    public void showGrid(Graphics graphics) {
        for (int i = 0; i < WIDTH / UNIT_SIZE; i++)
            graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, WIDTH);
        for (int i = 0; i < HEIGHT / UNIT_SIZE; i++)
            graphics.drawLine(0, i * UNIT_SIZE, WIDTH, i * UNIT_SIZE);
    }

    public void showApple(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
    }

    public void showSnake(Graphics graphics) {
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                graphics.setColor(Color.GREEN);
                graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            } else {
                graphics.setColor(new Color(45, 180, 0));
                graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'U':
                y[0] -= UNIT_SIZE;
                break;
            case 'D':
                y[0] += UNIT_SIZE;
                break;
            case 'R':
                x[0] += UNIT_SIZE;
                break;
            case 'L':
                x[0] -= UNIT_SIZE;
                break;
        }
    }

    public void newApple() {
        appleX = random.nextInt((int) (WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void checkAppe() {
        if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			eatenApples++;
            newApple();
        }
    }

    public void checkCollisions() {
        // checks if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        // check if head touches left border
        if (x[0] < 0)
            running = false;

        // check if head touches right border
        if (x[0] > WIDTH)
            running = false;

        // check if head touches top border
        if (y[0] < 0)
            running = false;

        // check if head touches bottom border
        if (y[0] > HEIGHT)
            running = false;

        if (!running)
            timer.stop();
    }

    public void showScore(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics = getFontMetrics(graphics.getFont());
		graphics.drawString("Score: "+ eatenApples, (WIDTH - metrics.stringWidth("Score: " + eatenApples))/2, graphics.getFont().getSize());

    }

    public void gameOver(Graphics graphics) {
        showScore(graphics);
		
		//Game Over text
		graphics.setColor(Color.red);
        graphics.setFont(new Font("Ink Free",Font.BOLD, 75));
        
		FontMetrics metrics2 = getFontMetrics(graphics.getFont());
		graphics.drawString("Game Over", (WIDTH - metrics2.stringWidth("Game Over"))/2, HEIGHT/2);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (running) {
            move();
            checkAppe();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R')
                        direction = 'L';
                    break;

                case KeyEvent.VK_RIGHT:
                    if (direction != 'L')
                        direction = 'R';
                    break;

                case KeyEvent.VK_UP:
                    if (direction != 'D')
                        direction = 'U';
                    break;

                case KeyEvent.VK_DOWN:
                    if (direction != 'U')
                        direction = 'D';
                    break;
            }
        }

    }

}
