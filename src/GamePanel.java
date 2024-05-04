import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel{
    private final int PANEL_WIDTH = 600;
    private final int PANEL_HEIGHT = 600;
    int pointX = 50;
    int pointY = 50;

    public GamePanel(){
        setBackground(Color.decode("#434242"));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        // Draw your game
        g.setColor(Color.decode("#222222"));
        g.fillRect(pointX, pointY, pointX+PANEL_WIDTH, pointY+PANEL_HEIGHT);
    }

}
