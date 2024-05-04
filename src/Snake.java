import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Snake {
    private final int x;
    private final int y;
    private final int moveSize;
    ArrayList<BodyPart> bodyParts = new ArrayList<>();

    public Snake(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.moveSize = size;
        bodyParts.add(new BodyPart(x+ 2*moveSize, y+2*moveSize,1));

    }

    public void move() {
        for (BodyPart part: bodyParts) {
            part.partMove(moveSize);
        }
        // System.out.println("Moved");
    }

    public void drawSnake(Graphics g){
        for (BodyPart part: bodyParts) {
            part.drawPart(g, moveSize);
        }
    }

    public void addBodyPart(){
        int tailIndex = bodyParts.size() - 1;
        BodyPart tail = bodyParts.get(tailIndex);
        switch (tail.direction) {
            case 0 -> bodyParts.add(new BodyPart(tail.x, tail.y + moveSize, tail.direction));
            case 1 -> bodyParts.add(new BodyPart(tail.x - moveSize, tail.y, tail.direction));
            case 2 -> bodyParts.add(new BodyPart(tail.x, tail.y - moveSize, tail.direction));
            case 3 -> bodyParts.add(new BodyPart(tail.x + moveSize, tail.y, tail.direction));
        }
    }

    public ArrayList<BodyPart> getBordyParts(){
        return bodyParts;
    }

    public void changeDirection(BodyPart part,int direction){
        part.direction = direction;
    }

    public void updateDirection(){
        int prev = 0;
        for (int i = 0; i < bodyParts.size(); i++) {
            if (bodyParts.size() != 1){
                BodyPart part = bodyParts.get(i);
                if (i == 0){
                    prev = part.direction;
                } else {
                    int prev_temp = part.direction;
                    part.direction = prev;
                    prev = prev_temp;
                }
            }
        }
    }

    public BodyPart getHead(){
        return bodyParts.get(0);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
