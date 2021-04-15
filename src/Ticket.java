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

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }



    public void setName(String name) {
        this.name = name;
    }

   public String getDepartureCity(){
       return departureCity;
   }
   public String getArrivalCity(){
       return arrivalCity;
   }
   public String getFlightID(){
       return flightId;
   }
   public int getSeatNum(){
       return seatNum;
   }
   public String getName(){
       return name;
   }
   
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