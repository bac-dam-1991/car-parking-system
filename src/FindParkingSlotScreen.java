/**
 * This class is a blueprint for the "Find Parking Slot" screen
 * It inherits from the abstract class Screen and implements ActionListener and ItemListener interfaces
 * @author Bac Trach Dam (102134383)
 * @version 1.0
 **/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FindParkingSlotScreen extends Screen implements ActionListener, FocusListener {

    private static final String CAR_REGISTRATION_METHOD = "Car's registration number";
    private static final String PARKING_SLOT_ID_METHOD = "Parking slot ID";

    private JLabel promptLabel;
    private JComboBox<String> searchMethodComboBox;
    private JTextField searchTextField;
    private JButton findButton;
    private JButton returnButton;
    private JLabel notFoundLabel;

    private JPanel parkingSlotDetailsContainer;
    private JLabel parkingSlotTitleLabel;
    private JLabel parkingSlotTypeLabel;
    private JLabel parkingSlotIdLabel;
    private JLabel parkingSlotIsOccupiedLabel;

    private JPanel carDetailsContainer;
    private JLabel carTitleLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel registrationNumberLabel;
    private JLabel ownerTypeLabel;

    private GridBagConstraints promptLabelConstraints;
    private GridBagConstraints searchMethodComboBoxConstraints;
    private GridBagConstraints searchTextFieldConstraints;
    private GridBagConstraints findButtonConstraints;
    private GridBagConstraints returnButtonConstraints;
    private GridBagConstraints notFoundLabelConstraints;

    private GridBagConstraints parkingSlotDetailsContainerConstraints;
    private GridBagConstraints parkingSlotTitleLabelConstraints;
    private GridBagConstraints parkingSlotTypeLabelConstraints;
    private GridBagConstraints parkingSlotIdLabelConstraints;
    private GridBagConstraints parkingSlotIsOccupiedLabelConstraints;

    private GridBagConstraints carDetailsContainerConstraints;
    private GridBagConstraints carTitleLabelConstraints;
    private GridBagConstraints firstNameLabelConstraints;
    private GridBagConstraints lastNameLabelConstraints;
    private GridBagConstraints registrationNumberLabelConstraints;
    private GridBagConstraints ownerTypeLabelConstraints;

    /**
     *
     * @param container - the parent container
     */
    protected FindParkingSlotScreen(JPanel container) {
        super(new GridBagLayout());
        container.add(this, Screen.FIND_PARKING_SLOT);
        this.attachComponents();
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements
     */
    @Override
    protected void createComponents() {
        this.promptLabel = new JLabel("Find parking slot by");

        String[] searchMethods = new String[] {
                FindParkingSlotScreen.CAR_REGISTRATION_METHOD,
                FindParkingSlotScreen.PARKING_SLOT_ID_METHOD
        };
        this.searchMethodComboBox = new JComboBox<>(searchMethods);
        this.searchTextField = new JTextField();
        this.findButton = new JButton("Find");
        this.returnButton = new JButton("Back");
        this.notFoundLabel = new JLabel("");

        this.parkingSlotDetailsContainer = new JPanel(new GridBagLayout());
        this.parkingSlotTitleLabel = new JLabel("PARKING SLOT DETAILS");
        this.parkingSlotTypeLabel = new JLabel("Parking slot type:");
        this.parkingSlotIdLabel = new JLabel("Parking slot ID:");
        this.parkingSlotIsOccupiedLabel = new JLabel("Parking slot is occupied:");

        this.carDetailsContainer = new JPanel(new GridBagLayout());
        this.carTitleLabel = new JLabel("");
        this.firstNameLabel = new JLabel("");
        this.lastNameLabel = new JLabel("");
        this.registrationNumberLabel = new JLabel("");
        this.ownerTypeLabel = new JLabel("");
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore attachment of those children will also be different.
     */
    @Override
    protected void attachComponents() {
        this.add(this.promptLabel, this.promptLabelConstraints);
        this.add(this.searchMethodComboBox, this.searchMethodComboBoxConstraints);
        this.add(this.searchTextField, this.searchTextFieldConstraints);
        this.add(this.findButton, this.findButtonConstraints);
        this.add(this.returnButton, this.returnButtonConstraints);
        this.add(this.notFoundLabel, this.notFoundLabelConstraints);

        this.add(this.parkingSlotDetailsContainer, this.parkingSlotDetailsContainerConstraints);
        this.attachParkingSlotDetailsContainerComponents();

        this.add(this.carDetailsContainer, this.carDetailsContainerConstraints);
        this.attachCarDetailsContainerComponents();

    }

    private void attachParkingSlotDetailsContainerComponents() {
        this.parkingSlotDetailsContainer.add(this.parkingSlotTitleLabel, this.parkingSlotTitleLabelConstraints);
        this.parkingSlotDetailsContainer.add(this.parkingSlotTypeLabel, this.parkingSlotTypeLabelConstraints);
        this.parkingSlotDetailsContainer.add(this.parkingSlotIdLabel, this.parkingSlotIdLabelConstraints);
        this.parkingSlotDetailsContainer.add(this.parkingSlotIsOccupiedLabel, this.parkingSlotIsOccupiedLabelConstraints);
    }

    private void attachCarDetailsContainerComponents() {
        this.carDetailsContainer.add(this.carTitleLabel, this.carTitleLabelConstraints);
        this.carDetailsContainer.add(this.firstNameLabel, this.firstNameLabelConstraints);
        this.carDetailsContainer.add(this.lastNameLabel, this.lastNameLabelConstraints);
        this.carDetailsContainer.add(this.registrationNumberLabel, this.registrationNumberLabelConstraints);
        this.carDetailsContainer.add(this.ownerTypeLabel, this.ownerTypeLabelConstraints);
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

        this.searchMethodComboBoxConstraints = new GridBagConstraints();
        this.searchMethodComboBoxConstraints.gridx = 1;
        this.searchMethodComboBoxConstraints.gridy = 0;
        this.searchMethodComboBoxConstraints.insets = new Insets(0, 8, 8, 0);
        this.searchMethodComboBoxConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.searchMethodComboBoxConstraints.gridwidth = 2;

        this.searchTextFieldConstraints = new GridBagConstraints();
        this.searchTextFieldConstraints.gridx = 0;
        this.searchTextFieldConstraints.gridy = 1;
        this.searchTextFieldConstraints.insets = new Insets(0, 0, 8, 0);
        this.searchTextFieldConstraints.fill = GridBagConstraints.HORIZONTAL;

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

        this.parkingSlotDetailsContainerConstraints = new GridBagConstraints();
        this.parkingSlotDetailsContainerConstraints.gridx = 0;
        this.parkingSlotDetailsContainerConstraints.gridy = 3;
        this.parkingSlotDetailsContainerConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.parkingSlotDetailsContainerConstraints.gridheight = 5;

        this.parkingSlotTitleLabelConstraints = new GridBagConstraints();
        this.parkingSlotTitleLabelConstraints.gridx = 0;
        this.parkingSlotTitleLabelConstraints.gridy = 0;
        this.parkingSlotTitleLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.parkingSlotTitleLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.parkingSlotIdLabelConstraints = new GridBagConstraints();
        this.parkingSlotIdLabelConstraints.gridx = 0;
        this.parkingSlotIdLabelConstraints.gridy = 1;
        this.parkingSlotIdLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.parkingSlotIdLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.parkingSlotTypeLabelConstraints = new GridBagConstraints();
        this.parkingSlotTypeLabelConstraints.gridx = 0;
        this.parkingSlotTypeLabelConstraints.gridy = 2;
        this.parkingSlotTypeLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.parkingSlotTypeLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.parkingSlotIsOccupiedLabelConstraints = new GridBagConstraints();
        this.parkingSlotIsOccupiedLabelConstraints.gridx = 0;
        this.parkingSlotIsOccupiedLabelConstraints.gridy = 3;
        this.parkingSlotIsOccupiedLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.parkingSlotIsOccupiedLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.carDetailsContainerConstraints = new GridBagConstraints();
        this.carDetailsContainerConstraints.gridx = 1;
        this.carDetailsContainerConstraints.gridy = 3;
        this.carDetailsContainerConstraints.insets = new Insets(0, 8, 0, 0);
        this.carDetailsContainerConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.carDetailsContainerConstraints.gridwidth = 2;
        this.carDetailsContainerConstraints.gridheight = 5;

        this.carTitleLabelConstraints = new GridBagConstraints();
        this.carTitleLabelConstraints.gridx = 0;
        this.carTitleLabelConstraints.gridy = 0;
        this.carTitleLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.carTitleLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.firstNameLabelConstraints = new GridBagConstraints();
        this.firstNameLabelConstraints.gridx = 0;
        this.firstNameLabelConstraints.gridy = 1;
        this.firstNameLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.firstNameLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.lastNameLabelConstraints = new GridBagConstraints();
        this.lastNameLabelConstraints.gridx = 0;
        this.lastNameLabelConstraints.gridy = 2;
        this.lastNameLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.lastNameLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.registrationNumberLabelConstraints = new GridBagConstraints();
        this.registrationNumberLabelConstraints.gridx = 0;
        this.registrationNumberLabelConstraints.gridy = 3;
        this.registrationNumberLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.registrationNumberLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.ownerTypeLabelConstraints = new GridBagConstraints();
        this.ownerTypeLabelConstraints.gridx = 0;
        this.ownerTypeLabelConstraints.gridy = 4;
        this.ownerTypeLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore attachment of action listeners will be different
     */
    @Override
    protected void attachListeners() {
        this.findButton.addActionListener(this);
        this.returnButton.addActionListener(this);
        this.searchTextField.addFocusListener(this);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore setting dimensions will be different
     */
    @Override
    protected void setDimensions() {
        this.promptLabel.setPreferredSize(new Dimension(284, 24));
        this.searchMethodComboBox.setPreferredSize(new Dimension(208, 24));
        this.searchTextField.setPreferredSize(new Dimension(284, 24));
        this.findButton.setPreferredSize(new Dimension(100, 24));
        this.returnButton.setPreferredSize(new Dimension(100, 24));
        this.notFoundLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.parkingSlotDetailsContainer.setPreferredSize(new Dimension(284, 160));
        this.carDetailsContainer.setPreferredSize(new Dimension(208, 160));
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
        this.clearTextForCarsLabels();
        this.resetParkingSlotLabels();

        if (source.equals(this.findButton)) {

            ParkingSlot foundParkingSlot = null;

            String searchMethod = String.valueOf(this.searchMethodComboBox.getSelectedItem());

            if (searchMethod.equals(FindParkingSlotScreen.CAR_REGISTRATION_METHOD)) {
                String carRegistrationNumber = this.searchTextField.getText();

                if(!Car.registrationNumberIsValid(carRegistrationNumber)){
                    this.notFoundLabel.setText("Registration number *Must begins with one capital letter, follows by 5 digits.");
                    this.notFoundLabel.setForeground(Color.red);
                    return ;
                }

                foundParkingSlot = Application.CARPARK.findParkingSlotByCarRegistrationNumber(carRegistrationNumber);

            } else if (searchMethod.equals((FindParkingSlotScreen.PARKING_SLOT_ID_METHOD))) {
                String parkingSlotId = this.searchTextField.getText();
                foundParkingSlot = Application.CARPARK.findParkingSlotByParkingSlotId(parkingSlotId);
            }

            if (foundParkingSlot == null) {
                if (searchMethod.equals(FindParkingSlotScreen.CAR_REGISTRATION_METHOD)) {
                    this.notFoundLabel.setText("No parking slot found with the provided registration number.");
                } else if (searchMethod.equals((FindParkingSlotScreen.PARKING_SLOT_ID_METHOD))) {
                    this.notFoundLabel.setText("No parking slot found.");
                }
                this.notFoundLabel.setForeground(Color.red);
                return;
            }

            this.setTextForParkingSlotsLabels(foundParkingSlot);

            Car parkedCar = foundParkingSlot.getParkedCar();

            if (parkedCar != null) {
                this.setTextForCarsLabels(parkedCar);
            } else {
                this.clearTextForCarsLabels();
            }

        } else if (source.equals(this.returnButton)) {
            returnToConsole();
        }
    }

    /**
     * Reset the parking slots labels to initial values
     */
    private void resetParkingSlotLabels() {
        this.parkingSlotTypeLabel.setText("Parking slot type:");
        this.parkingSlotIdLabel.setText("Parking slot ID:");
        this.parkingSlotIsOccupiedLabel.setText("Parking slot is occupied:");
    }

    /**
     * Set the text for the parking slots as per the parking slot details
     * @param parkingSlot - the parking slot of interest
     */
    private void setTextForParkingSlotsLabels(ParkingSlot parkingSlot){
        this.parkingSlotTypeLabel.setText("Parking slot type: " + parkingSlot.getType());
        this.parkingSlotIdLabel.setText("Parking slot ID: " + parkingSlot.getId());
        this.parkingSlotIsOccupiedLabel.setText("Parking slot is occupied: " + (parkingSlot.getParkedCar() == null ? String.valueOf(false) : String.valueOf(true)));
    }

    /**
     * Clear the car's labels
     */
    private void clearTextForCarsLabels() {
        this.carTitleLabel.setText("");
        this.firstNameLabel.setText("");
        this.lastNameLabel.setText("");
        this.registrationNumberLabel.setText("");
        this.ownerTypeLabel.setText("");
    }

    /**
     * Set text for cars label as per the car of interest
     * @param parkedCar - the car of interest
     */
    private void setTextForCarsLabels(Car parkedCar) {
        this.carTitleLabel.setText("CAR'S DETAILS");
        this.firstNameLabel.setText("First name: " + parkedCar.getFirstname());
        this.lastNameLabel.setText("Last name: " + parkedCar.getLastname());
        this.registrationNumberLabel.setText("Registration number: " + parkedCar.getRegistrationNumber());
        this.ownerTypeLabel.setText("Owner type: " + parkedCar.getOwnerType());
    }

    /**
     * Return to console
     */
    private void returnToConsole() {
        new ConsoleScreen((JPanel) this.getParent());
        this.goTo(Screen.CONSOLE);
        this.dismountSelf();
    }

    /**
     * Invoked when a component gains the keyboard focus.
     *
     * @param e the event to be processed
     */
    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();

        if (source.equals(this.searchTextField)) {
            this.notFoundLabel.setText("");
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
