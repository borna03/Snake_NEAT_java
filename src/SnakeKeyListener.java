import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeKeyListener implements KeyListener {
    private final Snake snake;

    public SnakeKeyListener(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        BodyPart head = snake.getHead();

        switch (keyCode) {
            case KeyEvent.VK_W -> snake.changeDirection(head, 0);
            case KeyEvent.VK_D -> snake.changeDirection(head, 1);
            case KeyEvent.VK_S -> snake.changeDirection(head, 2);
            case KeyEvent.VK_A -> snake.changeDirection(head, 3);
            case KeyEvent.VK_SPACE -> {
                snake.addBodyPart();
            }
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
