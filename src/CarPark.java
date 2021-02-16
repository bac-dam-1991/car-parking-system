/**
 * This class is a blueprint for a CarPark instance
 * @author Bac Trach Dam (102134383)
 * @version 1.0
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarPark {
    private ArrayList<ParkingSlot> parkingSlots = new ArrayList<>();

    public CarPark() {}

    /**
     * Constructor
     * @param numberOfStaffParkingSlot - the number of parking slot for staff
     * @param numberOfVisitorParkingSlot - the number of parking slot for visitor
     * */
    public CarPark(int numberOfStaffParkingSlot, int numberOfVisitorParkingSlot) {
       this.create(numberOfStaffParkingSlot, numberOfVisitorParkingSlot);
    }

    /**
     * Constructor
     * @param numberOfStaffParkingSlot - the number of parking slot for staff
     * @param numberOfVisitorParkingSlot - the number of parking slot for visitor
     * */
    public void create(int numberOfStaffParkingSlot, int numberOfVisitorParkingSlot)
    {
        for(int i = 0; i < numberOfStaffParkingSlot; i++) {
            this.addAParkingSlot(ParkingSlot.STAFF_TYPE);
        }

        for(int i = 0; i < numberOfVisitorParkingSlot; i++) {
            this.addAParkingSlot(ParkingSlot.VISITOR_TYPE);
        }
    }

    /**
     * This method finds the parking slot by the provided parking slot id
     * @param parkingSlotId - the parking slot id we want
     * @return the parking slot we want if exists
     * */
    public ParkingSlot findParkingSlotByParkingSlotId(String parkingSlotId) {
        List<ParkingSlot> result = parkingSlots
                                    .stream()
                                    .filter(
                                        parkingSlot -> parkingSlot
                                                        .getId()
                                                        .equalsIgnoreCase(parkingSlotId)
                                    )
                                    .collect(Collectors.toList());

        if (result.size() == 0) return null;

        return result.get(0);
    }

    /**
     * This method finds the parking slot by the car's registration number
     * @param registrationNumber - the registration number of the car we want to find
     * @return the parking slot that contains the car with the registration number provided
     *
     * */
    public ParkingSlot findParkingSlotByCarRegistrationNumber(String registrationNumber) {
        List<ParkingSlot> result = parkingSlots
                                    .stream()
                                    .filter(
                                        parkingSlot -> {
                                            Car parkedCar = parkingSlot.getParkedCar();
                                            if (parkedCar == null) return false;
                                            return parkedCar.getRegistrationNumber().equals(registrationNumber);
                                        }
                                    )
                                    .collect(Collectors.toList());
        if (result.size() == 0) return null;

        return result.get(0);
    }

    /**
     * This method adds a parking slot
     * @param type - the parking slot type, i.e., staff or visitor
     * @return the newly created parking slot
     * */
    public ParkingSlot addAParkingSlot(String type){
        ParkingSlot newParkingSlot = new ParkingSlot(type);
        parkingSlots.add((newParkingSlot));
        return newParkingSlot;
    }

    /**
     * This method deletes a parking slot
     * @param parkingSlotToRemove - the parking slot to remote
     * */
    public void deleteAParkingSlot(ParkingSlot parkingSlotToRemove) {
        this.parkingSlots.remove(parkingSlotToRemove);
    }

    /**
     * This method finds the car with the provided registration number
     * @param registrationNumber - the registration number we want to find
     * @return the car with the matching registration number
     * */
    public Car findACarByRegistrationNumber(String registrationNumber){
        List<ParkingSlot> result = parkingSlots.stream().filter(
                                        parkingSlot -> parkingSlot.isOccupied() &&
                                        parkingSlot.getParkedCar().getRegistrationNumber().equals(registrationNumber)
                                    ).collect(Collectors.toList());
        if (result.size() == 0) {
            return null;
        }

        return result.get(0).getParkedCar();
    }

    /**
     * This method returns only available parking slots
     * @return ArrayList of ParkingSlot
     */
    public ArrayList<ParkingSlot> getAvailableParkingSlots() {
        return (ArrayList<ParkingSlot>) parkingSlots.stream().filter(parkingSlot -> !parkingSlot.isOccupied()).collect(Collectors.toList());
    }

    /**
     * This method returns only occupied parking slots
     * @return ArrayList of ParkingSlot
     */
    public ArrayList<ParkingSlot> getOccupiedParkingSlots() {
        return (ArrayList<ParkingSlot>) parkingSlots.stream().filter(parkingSlot -> parkingSlot.isOccupied()).collect(Collectors.toList());
    }

    /**
     * This method parks a car
     * @param requestedParkingSlot - the parking slot we want to park the car in
     * @param incomingCar - the car we want to park
     * */
    public void parkCar(ParkingSlot requestedParkingSlot, Car incomingCar) {
        requestedParkingSlot.setOccupied(true);
        requestedParkingSlot.setParkedCar(incomingCar);
    }

    public List<ParkingSlot> getParkingSlotsByType(String type) {

        return this.parkingSlots
                .stream()
                .filter(parkingSlot -> parkingSlot
                        .getType()
                        .equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    /**
     * This method returns the array list of parkign slots
     * @return array list of parking slots
     * */
    public ArrayList<ParkingSlot> getParkingSlots() {
        return this.parkingSlots;
    }
}
