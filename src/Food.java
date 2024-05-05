import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Food {
    private int x;
    private int y;
    private final Snake snake;
    private final Color color;

    public Food(Snake snake) {
        this.snake = snake;
        color = Color.red;
    }

    public void generateFood() {
        Random random = new Random();

        do {
            int randomX = random.nextInt(snake.PANEL_WIDTH);
            int randomY = random.nextInt(snake.PANEL_HEIGHT);
            x = randomX;
            y = randomY;

            boolean found = false;
            for (BodyPart obj : snake.bodyParts) {
                if (obj.x == randomX && obj.y == randomY) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return;
            }
        } while (true);
    }


    public void drawFood(Graphics g) {
        g.setColor(color);
        g.fillRect(50 + x * snake.moveSize, 50 + y * snake.moveSize, snake.moveSize, snake.moveSize);
    }

    public boolean checkCollision() {
        BodyPart head = snake.bodyParts.get(0);
        if (head.x == x && head.y == y) {
            generateFood();
            snake.addBodyPart();
            return true;
        }

        return false;
    }

    public void print(){
        BodyPart head = snake.bodyParts.get(0);
        // + ((head.y - 50) / 20) + " ----- " + x + "/" + y
//        System.out.println(((head.x - 50) / 20) + "/" + ((head.y - 50) / 20));
    }
}
