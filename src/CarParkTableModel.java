import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CarParkTableModel extends AbstractTableModel {

    private String[] columnNames = {"Slot Id", "Slot Type", "Car Reg.", "First Name", "Last Name", "Owner Type"};
    private Object[][] data;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public CarParkTableModel() {
         data = transformData(generateData());
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    private ArrayList<ArrayList<String>> generateData() {

        ArrayList<ParkingSlot> parkingSlots = Application.CARPARK.getParkingSlots();

        ArrayList<ArrayList<String>> data = new ArrayList<>();

        parkingSlots.forEach(slot -> {

            ArrayList<String> currentSlotData = new ArrayList<>();

            currentSlotData.add(slot.getId());
            currentSlotData.add(slot.getType());

            Car parkedCar = slot.getParkedCar();
            if (parkedCar != null) {
                currentSlotData.add(parkedCar.getRegistrationNumber());
                currentSlotData.add(parkedCar.getFirstname());
                currentSlotData.add(parkedCar.getLastname());
                currentSlotData.add(parkedCar.getOwnerType());
            } else {
                for (int i = 0; i < Application.FIELD_COUNT_FOR_CAR_DETAILS; i++)
                {
                    currentSlotData.add("");
                }
            }

            data.add(currentSlotData);
        });

        return data;
    }

    private String[][] transformData(ArrayList<ArrayList<String>> data) {

        String[][] transformedData = new String[data.size()][];

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList<String> row = data.get(i);
            transformedData[i] = row.toArray(new String[row.size()]);
        }

        return transformedData;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}
