import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private final int PANEL_WIDTH = 700, PANEL_HEIGHT = 700, GRID_GAP = 20, render = 10;
    private static final int FPS = 120;
    int pointX = 50, pointY = 50, score = 0;
    private final Snake snake;
    public Food food;

    private static final long FRAME_TIME = 1000 / FPS;

    JLabel label = new JLabel("Score: " + score);

    public GamePanel() {
        // Set the layout manager to null
        setLayout(null);

        setBackground(Color.decode("#434242"));
        snake = new Snake(2, 2, GRID_GAP, Color.BLUE, PANEL_WIDTH, PANEL_HEIGHT);
        food = new Food(snake);
        food.generateFood();

        // Add label creation and setup here
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.BLACK); // Set the text color to black
        label.setBounds(800, 50, 100, 50);
        add(label);

        setFocusable(true);
        requestFocusInWindow(true);
        SnakeKeyListener snakeKeyListener = new SnakeKeyListener(snake);
        addKeyListener(snakeKeyListener);

        startGameLoop();
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.decode("#272829"));

        for (int x = pointX; x <= pointX + PANEL_WIDTH; x += GRID_GAP) {
            g.drawLine(x, pointY, x, pointY + PANEL_HEIGHT);
        }

        for (int y = pointY; y <= pointY + PANEL_HEIGHT; y += GRID_GAP) {
            g.drawLine(pointX, y, pointX + PANEL_WIDTH, y);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw game
        g.setColor(Color.decode("#222222"));
        g.fillRect(pointX, pointY, PANEL_WIDTH, PANEL_HEIGHT);
        drawGrid(g);
        snake.drawSnake(g);
        food.drawFood(g);
    }

    private void startGameLoop() {
        new Thread(() -> {
            int fps = 0;
            while (true) {
                fps += 1;

                if (fps % render == 0) {
                    updateGame();
                    if (!snake.updateDirection()) {
                        score = 0;
                        SwingUtilities.invokeLater(() -> label.setText("Score: " + score));
                        break;
                    }
                    fps = 0;
                    food.print();

                    if (!snake.checkCollision()) {
                        score = 0;
                        SwingUtilities.invokeLater(() -> label.setText("Score: " + score));
                        break;
                    }

                    SwingUtilities.invokeLater(() -> label.setText("Score: " + score));

                }
                if (food.checkCollision()) {
                    score += 1;
                }
                try {
                    Thread.sleep(Math.max(0, FRAME_TIME));
                } catch (InternalError e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }

    public void updateGame() {
        snake.move();
        this.repaint();
    }
}
