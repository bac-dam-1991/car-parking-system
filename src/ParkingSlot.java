/**
 * This class is a blueprint for a ParkingSlot instance
 * @author Bac Trach Dam (102134383)
 * @version 1.0
 **/

public class ParkingSlot {
    private static int staffParkingSlotCount = 0;
    private static int visitorParkingSlotCount = 0;

    private String id;
    private boolean isOccupied;
    private Car parkedCar;
    private String type;

    public static final String STAFF_TYPE = "STAFF";
    public static final String VISITOR_TYPE = "VISITOR";

    /**
     * Constructor
     * @param type - the parking slot type, i.e., staff or visitor
     * */
    public ParkingSlot(String type) {
        this.id = generateIdByParkingSlotType(type);
        this.isOccupied = false;
        this.parkedCar = null;
        this.type = type.toLowerCase();
    }

    /**
     * This is a getter method for parking slot id
     * */
    public String getId() {
        return id;
    }

    /**
     * This is a getter method of isOccupied property
     * */
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * This is setter method for isOccupied property
     * */
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    /**
     * This is a getter method for the parked car
     * */
    public Car getParkedCar() {
        return this.parkedCar;
    }

    /**
     * This is a setter method for the parked car
     * */
    public void setParkedCar(Car incomingCar) {
        this.parkedCar = incomingCar;
    }

    /**
     * This is a getter method for the parking slot type
     * */
    public String getType() {
        return type;
    }

    /**
     * This is a setter method for the parking slot type
     * */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method generates a parking slot id according to the parking slot type
     * @param type - the parking slot type, staff or visitor
     * @return the id of the parking slot
     * */
    private String generateIdByParkingSlotType(String type) {

        String id = "";
        if (type.equalsIgnoreCase(STAFF_TYPE)) {
            staffParkingSlotCount++;
            id = String.format("%s%03d", type.substring(0, 1).toUpperCase(), staffParkingSlotCount);
        } else if(type.equalsIgnoreCase(VISITOR_TYPE)) {
            visitorParkingSlotCount++;
            id = String.format("%s%03d", type.substring(0, 1).toUpperCase(), visitorParkingSlotCount);
        }

        return id;
    }

    /**
     * This method checks if the car being parked and the parking slot have matching privilege
     * @param incomingCar - the car being parked
     * */
    public boolean incomingCarHasParkingPrivilege(Car incomingCar) {
        return incomingCar.getOwnerType().equals(this.type);
    }

    /**
     * This method checks if the parking slot type is valid
     * @param type - parking slot type, i.e., staff or visitor
     * */
    public static boolean parkingSlotTypeIsValid(String type) {
        return type.equalsIgnoreCase(STAFF_TYPE) || type.equalsIgnoreCase(VISITOR_TYPE);
    }

    /**
     * override toString() method to display parking slot details
     * */
    @Override
    public String toString() {
        return String.format("Slot id: %s, is for %s, and is %soccupied.", this.id, this.type, (this.isOccupied ? "" : "not "));
    }
}
