/**
 * This class is a blueprint for the "Remove Parking Slot" screen
 * It inherits from the abstract class Screen and implements ActionListener and ItemListener interfaces
 * @author Bac Trach Dam (102134383)
 * @version 1.0
 **/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RemoveParkingSlotScreen extends Screen implements ActionListener, ItemListener {

    private JLabel parkingSlotIdLabel;
    private JComboBox<String> selectedParkingSlotComboBox;
    private JLabel parkingSlotTypeLabel;
    private JButton confirmButton;
    private JButton cancelButton;

    private GridBagConstraints parkingSlotIdLabelConstraints;
    private GridBagConstraints selectedParkingSlotComboBoxConstraints;
    private GridBagConstraints parkingSlotTypeLabelConstraints;
    private GridBagConstraints confirmButtonConstraints;
    private GridBagConstraints cancelButtonConstraints;

    /**
     *
     * @param container - the parent container
     */
    protected RemoveParkingSlotScreen(JPanel container) {
        super(new GridBagLayout());
        container.add(this, Screen.REMOVE_PARKING_SLOT);
        this.attachComponents();
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements
     */
    @Override
    protected void createComponents() {
        try {
            String[] parkingSlotIds = this.getAvailableParkingSlotIds();

            if (parkingSlotIds.length == 0) {
                throw new NullPointerException();
            } else {
                this.selectedParkingSlotComboBox = new JComboBox<>(getAvailableParkingSlotIds());
                this.confirmButton = new JButton("Remove");
            }

            this.parkingSlotTypeLabel = new JLabel("Parking slot type: " + this.getParkingSlotType());

        } catch(NullPointerException exception) {
            this.selectedParkingSlotComboBox = new JComboBox<>(new String[]{});
            this.selectedParkingSlotComboBox.setEnabled(false);
            this.confirmButton = new JButton("Car park has no parking slot.");
            this.confirmButton.setEnabled(false);
        } finally {
            this.parkingSlotIdLabel = new JLabel("Select parking slot ID");
            this.parkingSlotTypeLabel = new JLabel("Parking slot type: ");
            this.cancelButton = new JButton("Cancel");
        }

    }

    /**
     * Get available parking slot ids
     * @return Array of parking slot ids
     */
    private String[] getAvailableParkingSlotIds() {
        // Get occupied parking slots
        ArrayList<ParkingSlot> parkingSlots = Application.CARPARK.getAvailableParkingSlots();

        // Initialise an empty array to store the ids in
        ArrayList<String> parkingSlotIds = new ArrayList<>();

        // Loop through each parking slots and add their ids into the empty string array
        parkingSlots.forEach(slot -> parkingSlotIds.add(slot.getId()));

        // Return the string array of parking slot ids
        return parkingSlotIds.toArray(new String[parkingSlots.size()]);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore attachment of those children will also be different.
     */
    @Override
    protected void attachComponents() {
        this.add(this.parkingSlotIdLabel, this.parkingSlotIdLabelConstraints);
        this.add(this.selectedParkingSlotComboBox, this.selectedParkingSlotComboBoxConstraints);
        this.add(this.parkingSlotTypeLabel, this.parkingSlotTypeLabelConstraints);
        this.add(this.confirmButton, this.confirmButtonConstraints);
        this.add(this.cancelButton, this.cancelButtonConstraints);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing layout constraints requirements.
     */
    @Override
    protected void setupConstraints() {
        this.parkingSlotIdLabelConstraints = new GridBagConstraints();
        this.parkingSlotIdLabelConstraints.gridx = 0;
        this.parkingSlotIdLabelConstraints.gridy = 0;
        this.parkingSlotIdLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.parkingSlotIdLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.selectedParkingSlotComboBoxConstraints = new GridBagConstraints();
        this.selectedParkingSlotComboBoxConstraints.gridx = 0;
        this.selectedParkingSlotComboBoxConstraints.gridy = 1;
        this.selectedParkingSlotComboBoxConstraints.insets = new Insets(0, 0, 8, 0);
        this.selectedParkingSlotComboBoxConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.parkingSlotTypeLabelConstraints = new GridBagConstraints();
        this.parkingSlotTypeLabelConstraints.gridx = 0;
        this.parkingSlotTypeLabelConstraints.gridy = 2;
        this.parkingSlotTypeLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.parkingSlotTypeLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.confirmButtonConstraints = new GridBagConstraints();
        this.confirmButtonConstraints.gridx = 0;
        this.confirmButtonConstraints.gridy = 3;
        this.confirmButtonConstraints.insets = new Insets(0, 0, 8, 0);
        this.confirmButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.cancelButtonConstraints = new GridBagConstraints();
        this.cancelButtonConstraints.gridx = 0;
        this.cancelButtonConstraints.gridy = 4;
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
        this.parkingSlotIdLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.selectedParkingSlotComboBox.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.parkingSlotTypeLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
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

            String parkingSlotID = String.valueOf(this.selectedParkingSlotComboBox.getSelectedItem());

            int option = JOptionPane.showOptionDialog(
                    null,
                    String.format("Are you sure you want to remove parking slot %s?", parkingSlotID),
                    "Confirmation required",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    Screen.CONFIRM_OPTIONS,
                    Screen.CONFIRM_OPTIONS[0]
            );

            // If yes, delete the selected parking slot
            if (option == JOptionPane.YES_OPTION) {
                Application.CARPARK.deleteAParkingSlot(this.getSelectedParkingSlot());
                JOptionPane.showMessageDialog(null, String.format("Parking slot %s has been removed.", parkingSlotID));

                this.returnToConsole();
            }
        } else if (source.equals(this.cancelButton)) {
            this.returnToConsole();
        }
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
        Object source = e.getSource();
        if (source.equals(this.selectedParkingSlotComboBox)) {
            this.parkingSlotTypeLabel.setText("Parking slot type: " + this.getParkingSlotType());
        }
    }

    /**
     * Get the type of the selected parking slot
     * @return the type of parking slot - STAFF or VISITOR
     */
    private String getParkingSlotType() {
        return this.getSelectedParkingSlot().getType();
    }

    /**
     * Get the selected parking slot
     * @return the parking slot
     */
    private ParkingSlot getSelectedParkingSlot() {
        String selectedId = String.valueOf(this.selectedParkingSlotComboBox.getSelectedItem());
        return Application.CARPARK.findParkingSlotByParkingSlotId(selectedId);
    }

    /**
     * Returns to console screen from this screen
     */
    private void returnToConsole() {
        new ConsoleScreen((JPanel) this.getParent());
        this.goTo(Screen.CONSOLE);
        this.dismountSelf();
    }
}
