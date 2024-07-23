import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
class Emplacement extends JPanel implements ActionListener {
    Snake snake = new Snake(50, 60, 3);
    Timer timer;
    Point nourriture;
    Random random = new Random();


    public Emplacement() {
        timer = new Timer(500, this); // Timer ticks every 100 milliseconds
        timer.start();
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                changeDirection(e.getKeyCode());
            }
        });
        genererNourriture();
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(20, 50, 500, 600);
        g.setColor(Color.gray);
        for (int i = 0; i < snake.getLongueur(); i++) {
            int posX = snake.getPosX(i);
            int posY = snake.getPosY(i); 
            g.fillOval(posX, posY, 40, 40);
        }
        g.setColor(Color.red);
        g.fillOval(nourriture.x, nourriture.y, 40, 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        checkCollision();
        checkNourriture();
        repaint();
    }

    public void changeDirection(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (snake.getDirection() != Direction.DOWN) {
                    snake.setDirection(Direction.UP);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (snake.getDirection() != Direction.UP) {
                    snake.setDirection(Direction.DOWN);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (snake.getDirection() != Direction.RIGHT) {
                    snake.setDirection(Direction.LEFT);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (snake.getDirection() != Direction.LEFT) {
                    snake.setDirection(Direction.RIGHT);
                }
                break;
        }
    }

    private void checkCollision() {
        int headX = snake.getPosX(0);
        int headY = snake.getPosY(0);
        if (headX < 20 || headX >= 520 || headY < 50 || headY >= 650) {
            timer.stop();
        }
    }

    private void checkNourriture() {
        // Check if snake's head is on the same position as the food
        if (snake.getPosX(0) == nourriture.x && snake.getPosY(0) == nourriture.y) {
            snake.augmenterLongueur();
            genererNourriture();
        }
    }

    private void genererNourriture() {
        int x = 10 + random.nextInt(12) * 40;
        int y = 60 + random.nextInt(15) * 40;
        nourriture = new Point(x, y);
    }
}