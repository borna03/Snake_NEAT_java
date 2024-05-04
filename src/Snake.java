import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Snake {
    private int x;
    private int y;
    private Color color;
    private int moveSize;

    public Snake(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.moveSize = size;
        this.color = color;

    }

    public void move(int dx, int dy) {
        x+= moveSize;
    }


    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, moveSize, moveSize);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
