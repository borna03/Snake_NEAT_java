import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel{
    private final int PANEL_WIDTH = 700;
    private final int PANEL_HEIGHT = 700;
    int pointX = 50;
    int pointY = 50;
    private final int GRID_GAP = 20;
    private Snake snake;

    public GamePanel(){
        setBackground(Color.decode("#434242"));
        snake = new Snake(pointX, pointY, GRID_GAP, Color.BLUE);
        setFocusable(true);
        requestFocusInWindow(true);
        SnakeKeyListener snakeKeyListener = new SnakeKeyListener(snake, GRID_GAP, this);
        addKeyListener(snakeKeyListener);

    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.decode("#272829"));

        for (int x = pointX; x<= pointX+PANEL_WIDTH; x+= GRID_GAP) {
            g.drawLine(x, pointY, x, pointY + PANEL_HEIGHT);
        }

        for (int y = pointY; y <= pointY + PANEL_HEIGHT; y += GRID_GAP) {
            g.drawLine(pointX, y, pointX + PANEL_WIDTH, y);
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        // Draw game
        g.setColor(Color.decode("#222222"));
        g.fillRect(pointX, pointY, PANEL_WIDTH, PANEL_HEIGHT);
        drawGrid(g);
        snake.draw(g);

    }

}
