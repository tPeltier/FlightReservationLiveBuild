import java.util.Random;
/**
 * class that randomly generates the flight seats available and then reserves the one the user chooses
 * 
 */
class FlightSeat {
    private boolean available;
    private String seatType;
    protected String classType;
    protected double extraCharge;
    private String assignedCustomer;
/**
 * random generator for flight seats
 */
    public FlightSeat() {
        available = true;
        classType = "Economy";
        extraCharge = 0.0;
        assignedCustomer = "No One";
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(3) + 1;
        switch(randomNumber) {
            case 1:
                seatType = "Window";
                break;
            case 2:
                seatType = "Aisle";
                break;
            case 3:
                seatType = "Middle";
                break;
        }
    }
/**
 * @return available seats
 */
    public boolean getAvailability() {
        return available;
    }
 /**
 * @param customerName reserve for customer ""
 */
    public void reserveFor(String customerName) {
        assignedCustomer = customerName;
        available = false;
    }
/**
* cancel reservation method
*/
    public void cancelReservation() {
        assignedCustomer = "No One";
        available = true;
    }
/**
* @return chosen seat type of customer
*/
    public String getSeatType() {
        return seatType;
    }
/**
* @return name of customer
*/
    public String getAssignedName() {
        return assignedCustomer;
    }
/**
* @return class type of seat
*/
    public String getClassType() {
        return classType;
    }
/**
* @return extra charge if any for chosen flight class and seat
*/
    public double getExtraCharge() {
        return extraCharge;
    }
/**
* print statement clarification for customer
*/
    public void classGreeting() {
        System.out.println("---Thank you for flying economy!---");
    }
}
