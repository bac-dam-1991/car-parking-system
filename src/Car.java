/**
 * This class is a blueprint for a Car instance
 * @author Bac Trach Dam (102134383)
 * @version 1.0
 **/

public class Car {

    private String registrationNumber;
    private String ownerType;
    private String firstname;
    private String lastname;

    /**
     * Constructor
     * @param registrationNumber - the registration number of the car
     * @param ownerType - the owner type of the car's owner
     * */
    public Car(String registrationNumber, String ownerType, String firstname, String lastname) {
        this.registrationNumber = registrationNumber;
        this.ownerType = ownerType;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * This method returns the owner type
     * @return owner type, i.e., staff or visitor
     * */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * This method returns the registration number
     * @return registration number
     * */
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    /**
     * This method uses regex pattern to check the registration number provided
     * @param registrationNumber - the registration number to validate
     * @return true or false, (valid or not, respectively)
     * */
    public static boolean registrationNumberIsValid(String registrationNumber) {
        return registrationNumber.matches("^[A-Z][0-9]{5}$");
    }

    /**
     * This method check if the owner type if valid
     * @param type - the owner type
     * @return true or false (valid owner type or not, respectively)
     * */
    public static boolean ownerTypeIsValid(String type) {
        return ParkingSlot.parkingSlotTypeIsValid(type);
    }

    /**
     * Getter method for first name
     * @return first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * setter method for first name
     * @param firstname - first name of car's owner
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Getter method for last name
     * @return last name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Setter method for last name
     * @param lastname - last name of car's owner
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
