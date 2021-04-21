import java.util.Random;

class FlightSeat {
    private boolean available;
    private String seatType;
    protected String classType;
    protected double extraCharge;
    private String assignedCustomer;

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
    public boolean getAvailability() {
        return available;
    }
    public void reserveFor(String customerName) {
        assignedCustomer = customerName;
        available = false;
    }
    public void cancelReservation() {
        assignedCustomer = "No One";
        available = true;
    }
    public String getSeatType() {
        return seatType;
    }
    public String getAssignedName() {
        return assignedCustomer;
    }
    public String getClassType() {
        return classType;
    }
    public double getExtraCharge() {
        return extraCharge;
    }
    public void classGreeting() {
        System.out.println("---Thank you for flying economy!---");
    }
}
