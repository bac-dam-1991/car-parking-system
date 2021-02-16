/**
 * This class is a blueprint for the "Park Car" screen
 * It inherits from the abstract class Screen and implements ActionListener and ItemListener interfaces
 * @author Bac Trach Dam (102134383)
 * @version 1.0
 **/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ParkCarScreen extends Screen implements ActionListener, ItemListener, FocusListener {

    private JComboBox<String> parkingSlotIdsComboBox;
    private JComboBox<String> customerTypesComboBox;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    private JLabel registrationNumberLabel;
    private JTextField registrationNumberTextField;
    private JButton parkCarButton;
    private JButton cancelButton;

    private GridBagConstraints parkingSlotIdsComboBoxConstraints;
    private GridBagConstraints customerTypesComboBoxConstraints;
    private GridBagConstraints firstNameLabelConstraints;
    private GridBagConstraints firstNameTextFieldConstraints;
    private GridBagConstraints lastNameLabelConstraints;
    private GridBagConstraints lastNameTextFieldConstraints;
    private GridBagConstraints registrationNumberLabelConstraints;
    private GridBagConstraints registrationNumberTextFieldConstraints;
    private GridBagConstraints parkCarButtonConstraints;
    private GridBagConstraints cancelButtonConstraints;

    protected ParkCarScreen(JPanel container) {
        super(new GridBagLayout());
        container.add(this, Screen.PARK_CAR);
        this.attachComponents();
    }

    /**
     * Get available parking slot ids for combo box
     * @return a string array of parking slot ids
     */
    private String[] getParkingSlotIds() {
        // Get available parking slots
        ArrayList<ParkingSlot> parkingSlots = Application.CARPARK.getAvailableParkingSlots();

        // Initialise an empty array to store the ids in
        ArrayList<String> parkingSlotIds = new ArrayList<>();

        // Loop through each parking slots and add their ids into the empty string array
        parkingSlots.forEach(slot -> parkingSlotIds.add(slot.getId()));

        // Return the string array of parking slot ids
        return parkingSlotIds.toArray(new String[parkingSlots.size()]);
    }

    /**
     * Initialise the components
     */
    @Override
    protected void createComponents() {
        this.parkingSlotIdsComboBox = new JComboBox<>(getParkingSlotIds());
        this.customerTypesComboBox = new JComboBox<>(new String[] {ParkingSlot.STAFF_TYPE, ParkingSlot.VISITOR_TYPE});
        this.firstNameLabel = new JLabel("First name");
        this.firstNameTextField = new JTextField(50);
        this.lastNameLabel = new JLabel("Last name");
        this.lastNameTextField = new JTextField(50);
        this.registrationNumberLabel = new JLabel("Registration number");
        this.registrationNumberTextField = new JTextField(10);
        this.parkCarButton = new JButton("Park");
        this.cancelButton = new JButton("Cancel");
    }

    /**
     * Attach components to JPanel
     */
    @Override
    protected void attachComponents() {
        this.add(this.parkingSlotIdsComboBox, this.parkingSlotIdsComboBoxConstraints);
        this.add(this.customerTypesComboBox, this.customerTypesComboBoxConstraints);
        this.add(this.firstNameLabel, this.firstNameLabelConstraints);
        this.add(this.firstNameTextField, this.firstNameTextFieldConstraints);
        this.add(this.lastNameLabel, this.lastNameLabelConstraints);
        this.add(this.lastNameTextField, this.lastNameTextFieldConstraints);
        this.add(this.registrationNumberLabel, this.registrationNumberLabelConstraints);
        this.add(this.registrationNumberTextField, this.registrationNumberTextFieldConstraints);
        this.add(this.parkCarButton, this.parkCarButtonConstraints);
        this.add(this.cancelButton, this.cancelButtonConstraints);
    }

    /**
     * Set up layout constraints for elements
     */
    @Override
    protected void setupConstraints() {
        this.parkingSlotIdsComboBoxConstraints = new GridBagConstraints();
        this.parkingSlotIdsComboBoxConstraints.gridx = 0;
        this.parkingSlotIdsComboBoxConstraints.gridy = 0;
        this.parkingSlotIdsComboBoxConstraints.insets = new Insets(0, 0, 8, 0);
        this.parkingSlotIdsComboBoxConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.customerTypesComboBoxConstraints = new GridBagConstraints();
        this.customerTypesComboBoxConstraints.gridx = 0;
        this.customerTypesComboBoxConstraints.gridy = 1;
        this.customerTypesComboBoxConstraints.insets = new Insets(0, 0, 8, 0);
        this.customerTypesComboBoxConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.firstNameLabelConstraints = new GridBagConstraints();
        this.firstNameLabelConstraints.gridx = 0;
        this.firstNameLabelConstraints.gridy = 2;
        this.firstNameLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.firstNameLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.firstNameTextFieldConstraints = new GridBagConstraints();
        this.firstNameTextFieldConstraints.gridx = 0;
        this.firstNameTextFieldConstraints.gridy = 3;
        this.firstNameTextFieldConstraints.insets = new Insets(0, 0, 8, 0);
        this.firstNameTextFieldConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.lastNameLabelConstraints = new GridBagConstraints();
        this.lastNameLabelConstraints.gridx = 0;
        this.lastNameLabelConstraints.gridy = 4;
        this.lastNameLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.lastNameLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.lastNameTextFieldConstraints = new GridBagConstraints();
        this.lastNameTextFieldConstraints.gridx = 0;
        this.lastNameTextFieldConstraints.gridy = 5;
        this.lastNameTextFieldConstraints.insets = new Insets(0, 0, 8, 0);
        this.lastNameTextFieldConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.registrationNumberLabelConstraints = new GridBagConstraints();
        this.registrationNumberLabelConstraints.gridx = 0;
        this.registrationNumberLabelConstraints.gridy = 6;
        this.registrationNumberLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.registrationNumberLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.registrationNumberTextFieldConstraints = new GridBagConstraints();
        this.registrationNumberTextFieldConstraints.gridx = 0;
        this.registrationNumberTextFieldConstraints.gridy = 7;
        this.registrationNumberTextFieldConstraints.insets = new Insets(0, 0, 8, 0);
        this.registrationNumberTextFieldConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.parkCarButtonConstraints = new GridBagConstraints();
        this.parkCarButtonConstraints.gridx = 0;
        this.parkCarButtonConstraints.gridy = 8;
        this.parkCarButtonConstraints.insets = new Insets(0, 0, 8, 0);
        this.parkCarButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.cancelButtonConstraints = new GridBagConstraints();
        this.cancelButtonConstraints.gridx = 0;
        this.cancelButtonConstraints.gridy = 9;
        this.cancelButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

    }

    /**
     * Attach all listeners
     */
    @Override
    protected void attachListeners() {
        this.parkCarButton.addActionListener(this);
        this.cancelButton.addActionListener(this);

        this.parkingSlotIdsComboBox.addItemListener(this);
        this.customerTypesComboBox.addItemListener(this);

        this.firstNameTextField.addFocusListener(this);
        this.lastNameTextField.addFocusListener(this);
        this.registrationNumberTextField.addFocusListener(this);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore setting dimensions will be different
     */
    @Override
    protected void setDimensions() {
        this.parkingSlotIdsComboBox.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.customerTypesComboBox.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.firstNameLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.firstNameTextField.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.lastNameLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.lastNameTextField.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.registrationNumberLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.registrationNumberTextField.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.parkCarButton.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.cancelButton.setPreferredSize(Screen.DEFAULT_DIMENSION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source.equals(parkCarButton)) {
            String firstName = this.firstNameTextField.getText();
            String lastName = this.lastNameTextField.getText();
            String registrationNumber = this.registrationNumberTextField.getText();
            String customerType = String.valueOf(this.customerTypesComboBox.getSelectedItem());
            String parkingSlotId = String.valueOf(this.parkingSlotIdsComboBox.getSelectedItem());
            ParkingSlot selectedParkingSlot = Application.CARPARK.findParkingSlotByParkingSlotId(parkingSlotId);

            // Check if first name is empty
            if (firstName.equalsIgnoreCase("")) {
                this.firstNameLabel.setText("First name *Cannot be empty");
                this.firstNameLabel.setForeground(Color.red);
                return;
            }

            // Check if last name is empty
            if (lastName.equalsIgnoreCase("")) {
                this.lastNameLabel.setText("Last name *Cannot be empty");
                this.lastNameLabel.setForeground(Color.red);
                return;
            }

            // Check if registration number is empty
            if (registrationNumber.equalsIgnoreCase("")) {
                this.registrationNumberLabel.setText("Registration number *Cannot be empty");
                this.registrationNumberLabel.setForeground(Color.red);
                return;
            }

            // Check if registration number is valid
            if (!Car.registrationNumberIsValid(registrationNumber)) {
                this.registrationNumberLabel.setText("Registration number *Must begins with one capital letter, follows by 5 digits.");
                this.registrationNumberLabel.setForeground(Color.red);
                return;
            }

            int option = JOptionPane.showOptionDialog(
                    null,
                    String.format("Are you sure you want to park the car in slot %s?", parkingSlotId),
                    "Confirmation required",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    Screen.CONFIRM_OPTIONS,
                    Screen.CONFIRM_OPTIONS[0]
            );

            if (option == JOptionPane.YES_OPTION) {
                // Create new car and park it into the car park
                Car newCar = new Car(registrationNumber, customerType, firstName, lastName);
                Application.CARPARK.parkCar(selectedParkingSlot, newCar);

                // Move to the next screen and dismount this one
                new ConsoleScreen((JPanel) this.getParent());
                this.goTo(Screen.CONSOLE);
                this.dismountSelf();
            }

        } else {
            // Move to the next screen and dismount this one
            new ConsoleScreen((JPanel) this.getParent());
            this.goTo(Screen.CONSOLE);
            this.dismountSelf();
        }


    }

    /**
     * If parking slot type and customer type do not match then the park button is disabled.
     * @param e - Item event
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (!parkingSlotTypeAndCustomerTypeMatch()) {
            this.parkCarButton.setEnabled(false);
            this.parkCarButton.setText("Parking slot type and customer type do not match.");
        } else {
            this.parkCarButton.setEnabled(true);
            this.parkCarButton.setText("Park");
        }
    }

    /**
     * This method compares the parking slot and customer type
     * @return true or false to the statement
     */
    private boolean parkingSlotTypeAndCustomerTypeMatch() {
        String customerType = String.valueOf(this.customerTypesComboBox.getSelectedItem());
        String parkingSlotId = String.valueOf(this.parkingSlotIdsComboBox.getSelectedItem());
        ParkingSlot selectedParkingSlot = Application.CARPARK.findParkingSlotByParkingSlotId(parkingSlotId);
        return customerType.equalsIgnoreCase(selectedParkingSlot.getType());
    }

    /**
     * Invoked when a component gains the keyboard focus.
     *
     * @param e the event to be processed
     */
    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if (source.equals(this.firstNameTextField)) {
            this.firstNameLabel.setText("First name");
            this.firstNameLabel.setForeground(Color.black);
        } else if (source.equals(this.lastNameTextField)) {
            this.lastNameLabel.setText("Last name");
            this.lastNameLabel.setForeground(Color.black);
        } else if (source.equals(this.registrationNumberTextField)) {
            this.registrationNumberLabel.setText("Registration number");
            this.registrationNumberLabel.setForeground(Color.black);
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
