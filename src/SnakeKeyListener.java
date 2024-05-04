import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeKeyListener implements KeyListener {
    private Snake snake;
    private int gridGap;
    private GamePanel gamePanel;

    public SnakeKeyListener(Snake snake, int gridGap, GamePanel gamePanel) {
        this.snake = snake;
        this.gridGap = gridGap;
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_D) {
            snake.move(gridGap, 0);
            gamePanel.repaint(); // Repaint the GamePanel after the snake moves
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used, but required by the KeyListener interface
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used, but required by the KeyListener interface
    }
}
