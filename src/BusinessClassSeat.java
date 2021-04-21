/**
 * extra fee class for business class flight
 * calculates extra for business class
 */
public class BusinessClassSeat extends FlightSeat {
    public BusinessClassSeat() {
        classType = "Business Class";
        extraCharge = 150.25;
    }
 /**
 * print statement
 * 
 */
    public void classGreeting() {
        System.out.println("---Thank you for flying business class!---");
    }
    

    
}
