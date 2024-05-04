import java.awt.*;

class BodyPart {
    public int x;
    public int y;
    public int direction;
    Color color;


    public BodyPart(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.direction = dir;
        this.color = Color.GREEN;
    }

    public void drawPart(Graphics g, int moveSize){
        g.setColor(color);
        g.fillRect(x, y, moveSize, moveSize);
    }

    public void partMove(int moveSize){
        if (direction == 0) {
            y -= moveSize;
        } else if (direction == 1) {
            x += moveSize;
        } else if (direction == 2) {
            y += moveSize;
        } else{
            x -= moveSize;
        }
    }

    public void printOutParts(){
        System.out.println(String.join(" ", String.valueOf((x-50)/20+1), String.valueOf((y-50)/20), String.valueOf(direction)));
    }
}
