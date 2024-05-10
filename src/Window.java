import javax.swing.JFrame;

public class Window extends JFrame{
    private static Window instance = null;
    private Window(){
        super("Window");
        setSize(1250, 840);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        getContentPane().add(gamePanel);

        setVisible(true);
    }

    public static Window getInstance() {
        if (instance == null) {
            instance = new Window();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Window frame = Window.getInstance();
    }
}