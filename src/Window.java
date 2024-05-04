import javax.swing.JFrame;

public class Window extends JFrame{
    public Window(){
        super("Window");
        setSize(1250, 840);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        getContentPane().add(gamePanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Window frame = new Window();
    }
}