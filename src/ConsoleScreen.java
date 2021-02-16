import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsoleScreen extends Screen implements ActionListener {
    public JLabel carFunctionsLabel;
    public JButton parkCarButton;
    public JButton removeCarButton;
    public JButton findCarButton;
    public JLabel parkingSlotFunctionsLabel;
    public JButton addParkingSlotButton;
    public JButton removeParkingSlotButton;
    public JButton findParkingSlotButton;
    public JTable carParkTable;
    public JScrollPane carParkTableContainer;

    public GridBagConstraints carFunctionsLabelConstraints;
    public GridBagConstraints parkCarButtonConstraints;
    public GridBagConstraints removeCarButtonConstraints;
    public GridBagConstraints findCarButtonConstraints;
    public GridBagConstraints parkingSlotFunctionsLabelConstraints;
    public GridBagConstraints addParkingSlotButtonConstraints;
    public GridBagConstraints removeParkingSlotButtonConstraints;
    public GridBagConstraints findParkingSlotButtonConstraints;


    public ConsoleScreen(JPanel container){
        super(new FlowLayout());
        container.add(this, Screen.CONSOLE);
        this.createTable();
        this.attachComponents();
    }

    @Override
    protected void createComponents() {
        this.carFunctionsLabel = new JLabel("Vehicle Management");
        this.parkCarButton = new JButton("Park");
        this.removeCarButton = new JButton("Remove");
        this.findCarButton = new JButton("Find");
        this.parkingSlotFunctionsLabel = new JLabel("Car Park Management");
        this.addParkingSlotButton = new JButton("Add");
        this.removeParkingSlotButton = new JButton("Remove");
        this.findParkingSlotButton = new JButton("Find");
    }

    private void createTable() {
        this.carParkTable = new JTable(new CarParkTableModel());
        this.configureTable();
        this.attachTable();
    }

    private void attachTable() {
        this.carParkTableContainer = new JScrollPane(this.carParkTable);
        this.carParkTableContainer.setPreferredSize(new Dimension(780, 300));
    }

    private void configureTable() {
        this.carParkTable.setFillsViewportHeight(true);
        this.carParkTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.carParkTable.setAutoCreateRowSorter(true);
    }

    @Override
    protected void attachComponents() {

        JPanel buttonsContainer = new JPanel(new GridBagLayout());

        buttonsContainer.add(this.carFunctionsLabel, this.carFunctionsLabelConstraints);
        buttonsContainer.add(this.parkCarButton, this.parkCarButtonConstraints);
        buttonsContainer.add(this.removeCarButton, this.removeCarButtonConstraints);
        buttonsContainer.add(this.findCarButton, this.findCarButtonConstraints);
        buttonsContainer.add(this.parkingSlotFunctionsLabel, this.parkingSlotFunctionsLabelConstraints);
        buttonsContainer.add(this.addParkingSlotButton, this.addParkingSlotButtonConstraints);
        buttonsContainer.add(this.removeParkingSlotButton, this.removeParkingSlotButtonConstraints);
        buttonsContainer.add(this.findParkingSlotButton, this.findParkingSlotButtonConstraints);

        this.add(buttonsContainer);
        this.add(this.carParkTableContainer);
    }

    @Override
    protected void setupConstraints() {
        this.carFunctionsLabelConstraints = new GridBagConstraints();
        this.carFunctionsLabelConstraints.gridx = 0;
        this.carFunctionsLabelConstraints.gridy = 0;
        this.carFunctionsLabelConstraints.insets = new Insets(0, 0, 8, 8);
        this.carFunctionsLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.parkCarButtonConstraints = new GridBagConstraints();
        this.parkCarButtonConstraints.gridx = 1;
        this.parkCarButtonConstraints.gridy = 0;
        this.parkCarButtonConstraints.insets = new Insets(0, 0, 8, 8);
        this.parkCarButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.removeCarButtonConstraints = new GridBagConstraints();
        this.removeCarButtonConstraints.gridx = 2;
        this.removeCarButtonConstraints.gridy = 0;
        this.removeCarButtonConstraints.insets = new Insets(0, 0, 8, 8);
        this.removeCarButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.findCarButtonConstraints = new GridBagConstraints();
        this.findCarButtonConstraints.gridx = 3;
        this.findCarButtonConstraints.gridy = 0;
        this.findCarButtonConstraints.insets = new Insets(0, 0, 8, 8);
        this.findCarButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.parkingSlotFunctionsLabelConstraints = new GridBagConstraints();
        this.parkingSlotFunctionsLabelConstraints.gridx = 0;
        this.parkingSlotFunctionsLabelConstraints.gridy = 1;
        this.parkingSlotFunctionsLabelConstraints.insets = new Insets(0, 0, 8, 8);
        this.parkingSlotFunctionsLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.addParkingSlotButtonConstraints = new GridBagConstraints();
        this.addParkingSlotButtonConstraints.gridx = 1;
        this.addParkingSlotButtonConstraints.gridy = 1;
        this.addParkingSlotButtonConstraints.insets = new Insets(0, 0, 8, 8);
        this.addParkingSlotButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.removeParkingSlotButtonConstraints = new GridBagConstraints();
        this.removeParkingSlotButtonConstraints.gridx = 2;
        this.removeParkingSlotButtonConstraints.gridy = 1;
        this.removeParkingSlotButtonConstraints.insets = new Insets(0, 0, 8, 8);
        this.removeParkingSlotButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.findParkingSlotButtonConstraints = new GridBagConstraints();
        this.findParkingSlotButtonConstraints.gridx = 3;
        this.findParkingSlotButtonConstraints.gridy = 1;
        this.findParkingSlotButtonConstraints.insets = new Insets(0, 0, 8, 8);
        this.findParkingSlotButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
    }

    @Override
    protected void attachListeners() {
        this.parkCarButton.addActionListener(this);
        this.removeCarButton.addActionListener(this);
        this.findCarButton.addActionListener(this);
        this.addParkingSlotButton.addActionListener(this);
        this.removeParkingSlotButton.addActionListener(this);
        this.findParkingSlotButton.addActionListener(this);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore setting dimensions will be different
     */
    @Override
    protected void setDimensions() {
        Dimension dim = new Dimension(160, 24);
        this.carFunctionsLabel.setPreferredSize(dim);
        this.parkCarButton.setPreferredSize(dim);
        this.removeCarButton.setPreferredSize(dim);
        this.findCarButton.setPreferredSize(dim);
        this.parkingSlotFunctionsLabel.setPreferredSize(dim);
        this.addParkingSlotButton.setPreferredSize(dim);
        this.removeParkingSlotButton.setPreferredSize(dim);
        this.findParkingSlotButton.setPreferredSize(dim);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source.equals(this.parkCarButton)) {
            new ParkCarScreen((JPanel) this.getParent());
            this.goTo(Screen.PARK_CAR);
        } else if (source.equals(this.removeCarButton)) {
            new RemoveCarScreen((JPanel) this.getParent());
            this.goTo(Screen.REMOVE_CAR);
        } else if (source.equals(this.findCarButton)) {
            new FindCarScreen((JPanel) this.getParent());
            this.goTo(Screen.FIND_CAR);
        } else if (source.equals(this.addParkingSlotButton)) {
            new AddParkingSlotScreen((JPanel) this.getParent());
            this.goTo(Screen.ADD_PARKING_SLOT);
        } else if (source.equals(this.removeParkingSlotButton)) {
            new RemoveParkingSlotScreen((JPanel) this.getParent());
            this.goTo(Screen.REMOVE_PARKING_SLOT);
        } else if (source.equals(this.findParkingSlotButton)) {
            new FindParkingSlotScreen((JPanel) this.getParent());
            this.goTo(Screen.FIND_PARKING_SLOT);
        }

        this.dismountSelf();
    }
}
