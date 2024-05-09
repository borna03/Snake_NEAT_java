import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Snake {
    public final int moveSize;
    ArrayList<BodyPart> bodyParts = new ArrayList<>();
    int PANEL_HEIGHT;
    int PANEL_WIDTH;

    public Snake(int x, int y, int size, Color color, int PANEL_WIDTH, int PANEL_HEIGHT) {
        this.moveSize = size;
        this.PANEL_WIDTH = PANEL_WIDTH/20;
        this.PANEL_HEIGHT = PANEL_HEIGHT/20;
        bodyParts.add(new BodyPart(x, y,1));

    }

    public void drawSnake(Graphics g){
        for (int i = 0; i < bodyParts.size(); i++) {
            BodyPart part = bodyParts.get(i);
            boolean isFirstPart = (i == 0);
            part.drawPart(g, moveSize, isFirstPart);
        }
    }

    public void addBodyPart(){
        int tailIndex = bodyParts.size() - 1;
        BodyPart tail = bodyParts.get(tailIndex);
        switch (tail.direction) {
            case 0 -> bodyParts.add(new BodyPart(tail.x, tail.y + 1, tail.direction));
            case 1 -> bodyParts.add(new BodyPart(tail.x - 1, tail.y, tail.direction));
            case 2 -> bodyParts.add(new BodyPart(tail.x, tail.y - 1, tail.direction));
            case 3 -> bodyParts.add(new BodyPart(tail.x + 1, tail.y, tail.direction));
        }
    }

    public void changeDirection(BodyPart part,int direction){
        part.direction = direction;
    }

    public boolean checkCollision() {
        BodyPart head = bodyParts.get(0);
        return head.x >= 0 && head.x < PANEL_WIDTH && head.y >= 0 && head.y < PANEL_HEIGHT;
    }

    public boolean updateDirection() {
        int prev = 0;
        BodyPart head = null;
        for (int i = 0; i < bodyParts.size(); i++) {
            BodyPart part = bodyParts.get(i);
            part.partMove(moveSize);
            if (bodyParts.size() != 1) {
                if (i == 0) {
                    prev = part.direction;
                    head = part;
                } else {
                    int prev_temp = part.direction;
                    part.direction = prev;
                    prev = prev_temp;

                    if (head.x == part.x && head.y == part.y) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public BodyPart getHead(){
        return bodyParts.get(0);
    }
}
