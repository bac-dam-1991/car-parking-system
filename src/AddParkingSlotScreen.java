/**
 * This class is a blueprint for the "Add Parking Slot" screen
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

public class AddParkingSlotScreen extends Screen implements ActionListener, FocusListener {

    private JLabel promptLabel;
    private JComboBox<String> parkingSlotTypeComboBox;
    private JLabel parkingSlotCountLabel;
    private JTextField parkingSlotCountTextField;
    private JButton createButton;
    private JButton cancelButton;

    private GridBagConstraints promptLabelConstraints;
    private GridBagConstraints parkingSlotTypeComboBoxConstraints;
    private GridBagConstraints parkingSlotCountLabelConstraints;
    private GridBagConstraints parkingSlotCountTextFieldConstraints;
    private GridBagConstraints createButtonConstraints;
    private GridBagConstraints cancelButtonConstraints;

    protected AddParkingSlotScreen(JPanel container) {
        super(new GridBagLayout());
        container.add(this, Screen.ADD_PARKING_SLOT);
        this.attachComponents();
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements
     */
    @Override
    protected void createComponents() {
        this.promptLabel = new JLabel("Parking slot type");
        this.parkingSlotTypeComboBox = new JComboBox<>(new String[]{ParkingSlot.STAFF_TYPE, ParkingSlot.VISITOR_TYPE});
        this.parkingSlotCountLabel = new JLabel("Number of parking slot to create");
        this.parkingSlotCountTextField = new JTextField();
        this.createButton = new JButton("Create");
        this.cancelButton = new JButton("Cancel");

    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore attachment of those children will also be different.
     */
    @Override
    protected void attachComponents() {
        this.add(this.promptLabel, this.promptLabelConstraints);
        this.add(this.parkingSlotTypeComboBox, this.parkingSlotTypeComboBoxConstraints);
        this.add(this.parkingSlotCountLabel, this.parkingSlotCountLabelConstraints);
        this.add(this.parkingSlotCountTextField, this.parkingSlotCountTextFieldConstraints);
        this.add(this.createButton, this.createButtonConstraints);
        this.add(this.cancelButton, this.cancelButtonConstraints);
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

        this.parkingSlotTypeComboBoxConstraints = new GridBagConstraints();
        this.parkingSlotTypeComboBoxConstraints.gridx = 0;
        this.parkingSlotTypeComboBoxConstraints.gridy = 1;
        this.parkingSlotTypeComboBoxConstraints.insets = new Insets(0, 0, 8, 0);
        this.parkingSlotTypeComboBoxConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.parkingSlotCountLabelConstraints = new GridBagConstraints();
        this.parkingSlotCountLabelConstraints.gridx = 0;
        this.parkingSlotCountLabelConstraints.gridy = 2;
        this.parkingSlotCountLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.parkingSlotCountLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.parkingSlotCountTextFieldConstraints = new GridBagConstraints();
        this.parkingSlotCountTextFieldConstraints.gridx = 0;
        this.parkingSlotCountTextFieldConstraints.gridy = 3;
        this.parkingSlotCountTextFieldConstraints.insets = new Insets(0, 0, 8, 0);
        this.parkingSlotCountTextFieldConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.createButtonConstraints = new GridBagConstraints();
        this.createButtonConstraints.gridx = 0;
        this.createButtonConstraints.gridy = 4;
        this.createButtonConstraints.insets = new Insets(0, 0, 8, 0);
        this.createButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.cancelButtonConstraints = new GridBagConstraints();
        this.cancelButtonConstraints.gridx = 0;
        this.cancelButtonConstraints.gridy = 5;
        this.cancelButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore attachment of action listeners will be different
     */
    @Override
    protected void attachListeners() {
        this.createButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
        this.parkingSlotCountTextField.addFocusListener(this);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore setting dimensions will be different
     */
    @Override
    protected void setDimensions() {
        this.promptLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.parkingSlotTypeComboBox.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.parkingSlotCountLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.parkingSlotCountTextField.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.createButton.setPreferredSize(Screen.DEFAULT_DIMENSION);
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
        if (source.equals(this.createButton)) {
            try {
                String parkingSlotType = String.valueOf(this.parkingSlotTypeComboBox.getSelectedItem());
                int count = Integer.parseInt(this.parkingSlotCountTextField.getText());

                int option = JOptionPane.showOptionDialog(
                        null,
                        String.format("Are you sure you want to create %d %s parking slots?", count, parkingSlotType),
                        "Confirmation required",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        Screen.CONFIRM_OPTIONS,
                        Screen.CONFIRM_OPTIONS[0]
                );

                if (option == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < count; i++){
                        Application.CARPARK.addAParkingSlot(parkingSlotType);
                    }

                    JOptionPane.showMessageDialog(null, String.format("%d %s parking slots were created.", count, parkingSlotType));

                    this.parkingSlotCountTextField.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "Action cancelled.");
                }

                returnToConsole();

            } catch (NumberFormatException exception) {
                this.parkingSlotCountLabel.setText("Number of parking slot to create *Must be a positive number.");
                this.parkingSlotCountLabel.setForeground(Color.red);
            }

        } else if (source.equals(this.cancelButton)) {
            returnToConsole();
        }
    }

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

        if (source.equals(this.parkingSlotCountTextField)){
            this.parkingSlotCountLabel.setText("Number of parking slot to create");
            this.parkingSlotCountLabel.setForeground(Color.black);
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
