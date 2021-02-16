import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    public static final CarPark CARPARK = new CarPark();
    public static final Dimension DIMENSION = new Dimension(820, 456);
    public static final int FIELD_COUNT_FOR_CAR_DETAILS = 4;

    public JPanel container;

    public Application() {
        super();
    }

    public Application(String title) {
        super(title);
    }

    public void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Application.DIMENSION);
        this.container = new JPanel(new CardLayout());
    }

    public void start() {
        this.getContentPane().add(this.container, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void attachScreens() {
        new LoginScreen(this.container);
        new SetupScreen(this.container);
    }

    public static void main(String[] args) {
        Application app = new Application("ParkX - Car Park Management System");
        app.init();
        app.attachScreens();
        app.start();
    }
}
