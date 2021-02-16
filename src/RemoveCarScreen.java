import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RemoveCarScreen extends Screen implements ActionListener, ItemListener {

    private JComboBox<String> selectedParkingSlotComboBox;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel registrationNumberLabel;
    private JLabel ownerTypeLabel;
    private JButton confirmButton;
    private JButton cancelButton;

    private GridBagConstraints selectedParkingSlotComboBoxConstraints;
    private GridBagConstraints firstNameLabelConstraints;
    private GridBagConstraints lastNameLabelConstraints;
    private GridBagConstraints registrationNumberLabelConstraints;
    private GridBagConstraints ownerTypeLabelConstraints;
    private GridBagConstraints confirmButtonConstraints;
    private GridBagConstraints cancelButtonConstraints;

    protected RemoveCarScreen(JPanel container) {
        super(new GridBagLayout());
        container.add(this, Screen.REMOVE_CAR);
        this.attachComponents();
        this.findCurrentlySelectedCar();
    }

    /**
     * Get parking slot ids of occupied parking slots
     */
    private String[] getOccupiedParkingSlotIds() {
        // Get occupied parking slots
        ArrayList<ParkingSlot> parkingSlots = Application.CARPARK.getOccupiedParkingSlots();

        // Initialise an empty array to store the ids in
        ArrayList<String> parkingSlotIds = new ArrayList<>();

        // Loop through each parking slots and add their ids into the empty string array
        parkingSlots.forEach(slot -> parkingSlotIds.add(slot.getId()));

        // Return the string array of parking slot ids
        return parkingSlotIds.toArray(new String[parkingSlots.size()]);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements
     */
    @Override
    protected void createComponents() {
        this.selectedParkingSlotComboBox = new JComboBox<>(getOccupiedParkingSlotIds());
        this.firstNameLabel = new JLabel("First name:");
        this.lastNameLabel = new JLabel("Last name:");
        this.registrationNumberLabel = new JLabel("Registration number:");
        this.ownerTypeLabel = new JLabel("Owner type:");
        this.confirmButton = new JButton("Remove");
        this.cancelButton = new JButton("Cancel");
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore attachment of those children will also be different.
     */
    @Override
    protected void attachComponents() {
        this.add(this.selectedParkingSlotComboBox, this.selectedParkingSlotComboBoxConstraints);
        this.add(this.firstNameLabel, this.firstNameLabelConstraints);
        this.add(this.lastNameLabel, this.lastNameLabelConstraints);
        this.add(this.registrationNumberLabel, this.registrationNumberLabelConstraints);
        this.add(this.ownerTypeLabel, this.ownerTypeLabelConstraints);
        this.add(this.confirmButton, this.confirmButtonConstraints);
        this.add(this.cancelButton, this.cancelButtonConstraints);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing layout constraints requirements.
     */
    @Override
    protected void setupConstraints() {
        this.selectedParkingSlotComboBoxConstraints = new GridBagConstraints();
        this.selectedParkingSlotComboBoxConstraints.gridx = 0;
        this.selectedParkingSlotComboBoxConstraints.gridy = 0;
        this.selectedParkingSlotComboBoxConstraints.insets = new Insets(0, 0, 8, 0);
        this.selectedParkingSlotComboBoxConstraints.fill = GridBagConstraints.HORIZONTAL;

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
        this.ownerTypeLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.ownerTypeLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.confirmButtonConstraints = new GridBagConstraints();
        this.confirmButtonConstraints.gridx = 0;
        this.confirmButtonConstraints.gridy = 5;
        this.confirmButtonConstraints.insets = new Insets(0, 0, 8, 0);
        this.confirmButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.cancelButtonConstraints = new GridBagConstraints();
        this.cancelButtonConstraints.gridx = 0;
        this.cancelButtonConstraints.gridy = 6;
        this.cancelButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore attachment of action listeners will be different
     */
    @Override
    protected void attachListeners() {
        this.confirmButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
        this.selectedParkingSlotComboBox.addItemListener(this);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore setting dimensions will be different
     */
    @Override
    protected void setDimensions() {
        this.selectedParkingSlotComboBox.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.firstNameLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.lastNameLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.registrationNumberLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.ownerTypeLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.confirmButton.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.cancelButton.setPreferredSize(Screen.DEFAULT_DIMENSION);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        // If confirm button is clicked then remove car
        if (source.equals(this.confirmButton)) {
            String parkingSlotId = String.valueOf(this.selectedParkingSlotComboBox.getSelectedItem());
            ParkingSlot selectedParkingSlot = Application.CARPARK.findParkingSlotByParkingSlotId(parkingSlotId);
            selectedParkingSlot.setOccupied(false);
            selectedParkingSlot.setParkedCar(null);
        }

        new ConsoleScreen((JPanel) this.getParent());
        this.goTo(Screen.CONSOLE);
        this.dismountSelf();
    }

    /**
     * Invoked when an item has been selected or deselected by the user.
     * The code written for this method performs the operations
     * that need to occur when an item is selected (or deselected).
     *
     * @param e the event to be processed
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        this.findCurrentlySelectedCar();
    }

    private void findCurrentlySelectedCar() {
        // Get the parked car
        try {
            String parkingSlotId = String.valueOf(this.selectedParkingSlotComboBox.getSelectedItem());
            ParkingSlot selectedParkingSlot = Application.CARPARK.findParkingSlotByParkingSlotId(parkingSlotId);
            Car occupyingCar = selectedParkingSlot.getParkedCar();

            // Display relevant information about the occupying car
            this.firstNameLabel.setText("First name: " + occupyingCar.getFirstname());
            this.lastNameLabel.setText("Last name: " + occupyingCar.getLastname());
            this.registrationNumberLabel.setText("First name: " + occupyingCar.getRegistrationNumber());
            this.ownerTypeLabel.setText("Owner type: " + occupyingCar.getOwnerType());
        } catch (NullPointerException exception) {
            this.selectedParkingSlotComboBox.setEnabled(false);
            this.confirmButton.setEnabled(false);
            this.confirmButton.setText("Car park is empty");
        }

    }
}
