import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FindCarScreen extends Screen implements ActionListener, FocusListener {

    private JLabel promptLabel;
    private JTextField registrationNumberTextField;
    private JButton findButton;
    private JButton returnButton;
    private JLabel notFoundLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel registrationNumberLabel;
    private JLabel ownerTypeLabel;

    private GridBagConstraints promptLabelConstraints;
    private GridBagConstraints registrationNumberTextFieldConstraints;
    private GridBagConstraints findButtonConstraints;
    private GridBagConstraints returnButtonConstraints;
    private GridBagConstraints notFoundLabelConstraints;
    private GridBagConstraints firstNameLabelConstraints;
    private GridBagConstraints lastNameLabelConstraints;
    private GridBagConstraints registrationNumberLabelConstraints;
    private GridBagConstraints ownerTypeLabelConstraints;

    /**
     *
     * @param container the parent JPanel container of this screen
     */
    protected FindCarScreen(JPanel container) {
        super(new GridBagLayout());
        container.add(this, Screen.FIND_CAR);
        this.attachComponents();
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements
     */
    @Override
    protected void createComponents() {
        this.promptLabel = new JLabel("Registration number");
        this.registrationNumberTextField = new JTextField();
        this.findButton = new JButton("Find");
        this.returnButton = new JButton("Back");
        this.notFoundLabel = new JLabel("");
        this.firstNameLabel = new JLabel("First name:");
        this.lastNameLabel = new JLabel("Last name:");
        this.registrationNumberLabel = new JLabel("Registration number:");
        this.ownerTypeLabel = new JLabel("Owner type:");
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore attachment of those children will also be different.
     */
    @Override
    protected void attachComponents() {
        this.add(this.promptLabel, this.promptLabelConstraints);
        this.add(this.registrationNumberTextField, this.registrationNumberTextFieldConstraints);
        this.add(this.findButton, this.findButtonConstraints);
        this.add(this.returnButton, this.returnButtonConstraints);
        this.add(this.notFoundLabel, this.notFoundLabelConstraints);
        this.add(this.firstNameLabel, this.firstNameLabelConstraints);
        this.add(this.lastNameLabel, this.lastNameLabelConstraints);
        this.add(this.registrationNumberLabel, this.registrationNumberLabelConstraints);
        this.add(this.ownerTypeLabel, this.ownerTypeLabelConstraints);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing layout constraints requirements.
     */
    @Override
    protected void setupConstraints() {

        this.promptLabelConstraints = new GridBagConstraints();
        this.promptLabelConstraints.gridx = 0;
        this.promptLabelConstraints.gridy = 0;
        this.promptLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.promptLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.promptLabelConstraints.gridwidth = 3;

        this.registrationNumberTextFieldConstraints = new GridBagConstraints();
        this.registrationNumberTextFieldConstraints.gridx = 0;
        this.registrationNumberTextFieldConstraints.gridy = 1;
        this.registrationNumberTextFieldConstraints.insets = new Insets(0, 0, 8, 0);
        this.registrationNumberTextFieldConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.findButtonConstraints = new GridBagConstraints();
        this.findButtonConstraints.gridx = 1;
        this.findButtonConstraints.gridy = 1;
        this.findButtonConstraints.insets = new Insets(0, 8, 8, 0);
        this.findButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.returnButtonConstraints = new GridBagConstraints();
        this.returnButtonConstraints.gridx = 2;
        this.returnButtonConstraints.gridy = 1;
        this.returnButtonConstraints.insets = new Insets(0, 8, 8, 0);
        this.returnButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.notFoundLabelConstraints = new GridBagConstraints();
        this.notFoundLabelConstraints.gridx = 0;
        this.notFoundLabelConstraints.gridy = 2;
        this.notFoundLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.notFoundLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.notFoundLabelConstraints.gridwidth = 3;

        this.firstNameLabelConstraints = new GridBagConstraints();
        this.firstNameLabelConstraints.gridx = 0;
        this.firstNameLabelConstraints.gridy = 3;
        this.firstNameLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.firstNameLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.firstNameLabelConstraints.gridwidth = 3;

        this.lastNameLabelConstraints = new GridBagConstraints();
        this.lastNameLabelConstraints.gridx = 0;
        this.lastNameLabelConstraints.gridy = 4;
        this.lastNameLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.lastNameLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.lastNameLabelConstraints.gridwidth = 3;

        this.registrationNumberLabelConstraints = new GridBagConstraints();
        this.registrationNumberLabelConstraints.gridx = 0;
        this.registrationNumberLabelConstraints.gridy = 5;
        this.registrationNumberLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.registrationNumberLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.registrationNumberLabelConstraints.gridwidth = 3;

        this.ownerTypeLabelConstraints = new GridBagConstraints();
        this.ownerTypeLabelConstraints.gridx = 0;
        this.ownerTypeLabelConstraints.gridy = 6;
        this.ownerTypeLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.ownerTypeLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.ownerTypeLabelConstraints.gridwidth = 3;
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore attachment of action listeners will be different
     */
    @Override
    protected void attachListeners() {
        this.findButton.addActionListener(this);
        this.returnButton.addActionListener(this);
        this.registrationNumberTextField.addFocusListener(this);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore setting dimensions will be different
     */
    @Override
    protected void setDimensions() {
        this.promptLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.registrationNumberTextField.setPreferredSize(new Dimension(284, 24));
        this.findButton.setPreferredSize(new Dimension(100, 24));
        this.returnButton.setPreferredSize(new Dimension(100, 24));
        this.notFoundLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.firstNameLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.lastNameLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.registrationNumberLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.ownerTypeLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        this.notFoundLabel.setText("");
        this.promptLabel.setText("Registration number");

        if (source.equals(this.findButton)) {
            String registrationNumber = this.registrationNumberTextField.getText();

            if(!Car.registrationNumberIsValid(registrationNumber)) {
                this.promptLabel.setText("Registration number *Must begins with one capital letter, follows by 5 digits.");
                this.promptLabel.setForeground(Color.red);
                return;
            }

            Car foundCar = Application.CARPARK.findACarByRegistrationNumber(registrationNumber);

            if(foundCar == null) {
                this.notFoundLabel.setText("The car with the provided registration number does not exist in the system.");
                this.notFoundLabel.setForeground(Color.red);
                this.firstNameLabel.setText("First name:");
                this.lastNameLabel.setText("Last name:");
                this.registrationNumberLabel.setText("Registration number:");
                this.ownerTypeLabel.setText("Owner type:");
            } else {
                this.firstNameLabel.setText("First name: " + foundCar.getFirstname());
                this.lastNameLabel.setText("Last name: " + foundCar.getLastname());
                this.registrationNumberLabel.setText("Registration number: " + foundCar.getRegistrationNumber());
                this.ownerTypeLabel.setText("Owner type: "+ foundCar.getOwnerType());
            }

        } else if (source.equals(this.returnButton)) {
            new ConsoleScreen((JPanel) this.getParent());
            this.goTo(Screen.CONSOLE);
            this.dismountSelf();
        }
    }

    /**
     * Invoked when a component gains the keyboard focus.
     *
     * @param e the event to be processed
     */
    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();

        if (source.equals(this.registrationNumberTextField)) {
            // Reset the label to initial text and color
            // when the search bar is being focused
            this.promptLabel.setText("Registration number");
            this.promptLabel.setForeground(Color.black);
        }
    }

    /**
     * Invoked when a component loses the keyboard focus.
     *
     * @param e the event to be processed
     */
    @Override
    public void focusLost(FocusEvent e) {

    }
}
