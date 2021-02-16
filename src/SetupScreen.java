import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.ExportException;

public class SetupScreen extends Screen implements ActionListener {
    public JLabel staffLabel;
    public JTextField staffTextField;
    public JLabel visitorLabel;
    public JTextField visitorTextField;
    public JButton createButton;
    public JLabel createErrorLabel;

    public GridBagConstraints staffLabelConstraints;
    public GridBagConstraints staffTextFieldConstraints;
    public GridBagConstraints visitorLabelConstraints;
    public GridBagConstraints visitorTextFieldConstraints;
    public GridBagConstraints createButtonConstraints;
    public GridBagConstraints createErrorLabelConstraints;

    public SetupScreen(JPanel container) {
        super(new GridBagLayout());
        container.add(this, Screen.SETUP);
        this.attachComponents();
    }

    @Override
    protected void createComponents() {
        this.staffLabel = new JLabel("Number of parking slots for staff: ");
        this.staffTextField = new JTextField(6);
        this.visitorLabel = new JLabel("Number of parking slots for visitor: ");
        this.visitorTextField = new JTextField(6);
        this.createButton = new JButton("Create");
        this.createErrorLabel = new JLabel("");
        this.createErrorLabel.setForeground(Color.red);
    }

    @Override
    protected void attachComponents() {
        this.add(this.staffLabel, this.staffLabelConstraints);
        this.add(this.staffTextField, this.staffTextFieldConstraints);
        this.add(this.visitorLabel, this.visitorLabelConstraints);
        this.add(this.visitorTextField, this.visitorTextFieldConstraints);
        this.add(this.createButton, this.createButtonConstraints);
        this.add(this.createErrorLabel, this.createErrorLabelConstraints);
    }

    @Override
    protected void setupConstraints() {
        this.staffLabelConstraints = new GridBagConstraints();
        this.staffLabelConstraints.gridx = 0;
        this.staffLabelConstraints.gridy = 0;
        this.staffLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.staffLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.staffTextFieldConstraints = new GridBagConstraints();
        this.staffTextFieldConstraints.gridx = 0;
        this.staffTextFieldConstraints.gridy = 1;
        this.staffTextFieldConstraints.insets = new Insets(0, 0, 8, 0);
        this.staffTextFieldConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.visitorLabelConstraints = new GridBagConstraints();
        this.visitorLabelConstraints.gridx = 0;
        this.visitorLabelConstraints.gridy = 2;
        this.visitorLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.visitorLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.visitorTextFieldConstraints = new GridBagConstraints();
        this.visitorTextFieldConstraints.gridx = 0;
        this.visitorTextFieldConstraints.gridy = 3;
        this.visitorTextFieldConstraints.insets = new Insets(0, 0, 8, 0);
        this.visitorTextFieldConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.createButtonConstraints = new GridBagConstraints();
        this.createButtonConstraints.gridx = 0;
        this.createButtonConstraints.gridy = 4;
        this.visitorTextFieldConstraints.insets = new Insets(0, 0, 8, 0);
        this.createButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.createErrorLabelConstraints = new GridBagConstraints();
        this.createErrorLabelConstraints.gridx = 0;
        this.createErrorLabelConstraints.gridy = 5;
        this.createErrorLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
    }

    @Override
    protected void attachListeners() {
        this.createButton.addActionListener(this);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore setting dimensions will be different
     */
    @Override
    protected void setDimensions() {
        this.staffLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.staffTextField.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.visitorLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.visitorTextField.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.createButton.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.createErrorLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
            int staffParkingSlotCount = Integer.parseInt(this.staffTextField.getText());
            int visitorParkingSlotCount = Integer.parseInt(this.visitorTextField.getText());

            if (staffParkingSlotCount < 1 || visitorParkingSlotCount < 1){
                throw new Exception("Please enter a positive number greater than 0.");
            }

            // Add parking slots into car park as per input
            Application.CARPARK.create(staffParkingSlotCount, visitorParkingSlotCount);

            new ConsoleScreen((JPanel) this.getParent());
            this.goTo(Screen.CONSOLE);
        }
        catch (NumberFormatException exception) {
            this.createErrorLabel.setText("Please enter valid numbers only.");
        } catch (Exception exception) {
            this.createErrorLabel.setText(exception.getMessage());
        }
    }
}
