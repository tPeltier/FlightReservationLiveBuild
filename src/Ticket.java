/**
* ticket class gets all info from other classes and returns a printed ticket
*/
public class Ticket {
   private String departureCity;
   private String arrivalCity;
   private String flightId;
   private int seatNum;
   private String name;
   private double totalPrice;
   private double seatCharge;
   private String duration;
   private String classType;
/**
 *  takes in all preset info and prints a ticket for the customer
 * @param chosenFlight user selected flight 
 * @param seatNum user selected seat number
 * @param name of user 
 */
   public Ticket (Flight chosenFlight, int seatNum, String name){
        this.departureCity = chosenFlight.getSourceCity();
        this.arrivalCity = chosenFlight.getDestinationCity();
        this.flightId = chosenFlight.getIdentifier();
        this.seatNum = seatNum;
        this.name = name;
        this.seatCharge = chosenFlight.getSeatUpcharge(seatNum);
        this.totalPrice = chosenFlight.getPrice() + seatCharge;
        this.duration = chosenFlight.getFlightTime();
        this.classType = chosenFlight.getSeatList().get(seatNum - 1).getClassType();
   }
/**
 * @param seatNum selection
 */
   public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }
/**
 * @param name of customer
 */
   public void setName(String name) {
        this.name = name;
    }
/**
 * @return departure city
 */
   public String getDepartureCity(){
       return departureCity;
   }
/**
* @return arrival city
*/  
   public String getArrivalCity(){
       return arrivalCity;
   }
/**
* @return flight ID
*/
   public String getFlightID(){
       return flightId;
   }
/**
* @return seat number
*/
   public int getSeatNum(){
       return seatNum;
   }
/**
* @return name of cutsomer
*/
   public String getName(){
       return name;
   }
/**
* cancel ticket reset method
*/
   public void cancelTicket(){
        this.departureCity = null;
        this.arrivalCity = null;
        this.flightId = null;
        this.seatNum = 0;
        this.name = null;
        this.totalPrice = 0;
        this.duration = null;
        this.classType = null;
   }
/**
* ticket print method
*/
   public void print() {
        //todo maybe add more info like airline ?
        System.out.println("");
        System.out.println("===========|TICKET|===========");
        System.out.println("------------------------------");
        System.out.println("Name on Ticket: " + name);
        System.out.println("Flight ID#: " + flightId);
        System.out.println("Class Type: " + classType);
        System.out.println("Seat #: " + seatNum);
        System.out.println("Departure City: " + departureCity);
        System.out.println("Arrival City: " + arrivalCity);
        System.out.println("Flight Duration: " + duration);
        System.out.printf("Ticket Price: %.2f USD %n" ,  totalPrice);
        System.out.println("------------------------------");
        System.out.println("==============================");
        System.out.println("");
   }
}
