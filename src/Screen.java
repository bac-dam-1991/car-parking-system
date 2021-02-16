import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Screen extends JPanel {
    /**
     * Names of the different screens
     */
    public static final String LOGIN = "LOGIN";
    public static final String SETUP = "SETUP";
    public static final String CONSOLE = "CONSOLE";
    public static final String PARK_CAR = "PARK_CAR";
    public static final String REMOVE_CAR = "REMOVE_CAR";
    public static final String FIND_CAR = "FIND_CAR";
    public static final String ADD_PARKING_SLOT = "ADD_PARKING_SLOT";
    public static final String REMOVE_PARKING_SLOT = "REMOVE_PARKING_SLOT";
    public static final String FIND_PARKING_SLOT = "FIND_PARKING_SLOT";
    public static final Dimension DEFAULT_DIMENSION = new Dimension(500, 24);
    public static final Object[] CONFIRM_OPTIONS = {"YES", "NO"};

    /**
     * Constructor for each screen
     * @param layoutManager - the desired layout manager
     */
    protected Screen(LayoutManager layoutManager) {
        this.init(layoutManager);
        this.createComponents();
        this.setDimensions();
        this.setupConstraints();
        this.attachListeners();
    }

    /**
     * Perform methods that are common to all screens
     */
    protected void init(LayoutManager layoutManager) {
        this.setPreferredSize(Application.DIMENSION);
        this.setLayout(layoutManager);
    };

    /**
     * Get parent's layout and cast it to CardLayout. Then render the desired screen via their screenName
     * @param screenName - the screen name of the desired screen to show
     */
    protected void goTo(String screenName) {
        ((CardLayout) this.getParent().getLayout()).show(this.getParent(), screenName);
    }

    /**
     * Remove unnecessary screens to save memory
     */
    protected void dismountSelf() {
        this.getParent().remove(this);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements
     */
    protected abstract void createComponents();

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore attachment of those children will also be different.
     */
    protected abstract void attachComponents();

    /**
     * Abstract method that children must implements as different screens have different Swing layout constraints requirements.
     */
    protected abstract void setupConstraints();

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore attachment of action listeners will be different
     */
    protected abstract void attachListeners();

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore setting dimensions will be different
     */
    protected abstract void setDimensions();
}
