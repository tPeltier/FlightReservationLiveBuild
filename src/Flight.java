
import java.util.ArrayList;
import java.util.Random;
/**
* methods compile and create seat info, source and destination info, distance calculator info, passenger info, and airline and flight Id info
*/
class Flight {
    private int numberOfSeats;
    private int economySeats;
    private int firstClassSeats;
    private int businessSeats;
    private ArrayList<FlightSeat> seatList = new ArrayList<FlightSeat>();
    private City source, destination;
    private int averageSpeed = 350; //mpH
    private double distance;
    private String airline;
    private String flightIdentifier;
    private String time;
    private double price;
/**
 * @param source city guest is leaving from
 * @param destination city guest is going to
 */
    public Flight(City source, City destination) {
        this.source = source;
        this.destination = destination;
        this.flightIdentifier = createFlightIdentifier();
        createSeats();
        this.distance = calculateDistance();
        this.time = setFlightTime();
        this.price = setPrice();
    }
/**
* @return airline guest chooses
*/
    public String getAirliner() {
        return airline;
    }
/**
 * @return flightIdentifier of guest chosen flight
 */
    private String createFlightIdentifier() {
        Random randomGenerator = new Random();
        int arrayIndex = randomGenerator.nextInt(5);
        int randomNumber1 = randomGenerator.nextInt(5);
        int randomNumber2 = randomGenerator.nextInt(5);
        String airliners[] = {"Delta Airlines", "American Airlines", "Spirit Airlines", "United Airlines", "SouthWest", "JetBlue"};
        airline = airliners[arrayIndex];
        String flightAbbreviation = airline.substring(0, 1).toUpperCase() + airline.substring(1, 2).toUpperCase();
        String flightIdentifier = flightAbbreviation + randomNumber1 + randomNumber2;
        return flightIdentifier;
    }
/**
 *  sets number of seats available on chosen flight
 */
    private void createSeats() {
        Random randomGenerator = new Random();
        this.numberOfSeats = randomGenerator.nextInt(10) + 2;
        firstClassSeats = randomGenerator.nextInt(3) + 1;
        businessSeats = randomGenerator.nextInt(3) + 1;
        economySeats = numberOfSeats - (firstClassSeats + businessSeats);
        for (int seat = 0; seat < economySeats; seat++) {
            seatList.add(new FlightSeat());
        }
        for (int seat = 0; seat < firstClassSeats; seat++) {
            seatList.add(new FirstClassSeat());
        }
        for (int seat = 0; seat < businessSeats; seat++) {
            seatList.add(new BusinessClassSeat());
        }
    }
/**
* @return number of seats getter
*/
    public int getTotalSeats() {
        return this.numberOfSeats;
    }
/**
 * displays available seats on chosen flight
 */
    public void getOpenSeats() {
        System.out.println();
        System.out.println("------------Open Seats on Flight " + this.getIdentifier() + "------------");
        int seat = 0;
        while (seat < numberOfSeats) {
            if (seatList.get(seat).getAvailability()) {
                System.out.printf("Seat#   %-3s  Class: %-15s  Type: %s %n", seat + 1, seatList.get(seat).getClassType(), seatList.get(seat).getSeatType());
                seat++;
            }
        }
        System.out.println("-------------------------------------------------");
    }
/** 
* @return distance between cities
*/
    private double calculateDistance() {
        DistanceCalculator disCalc = new DistanceCalculator();
        double distance = disCalc.calculateDistance(source, destination);
        return distance;
    }
/**
* method to get a flight's list of seats 
*/
    public ArrayList<FlightSeat> getSeatList() { // method to get a flight's list of seats for your classes (if it were to be needed)
        return seatList;
    }
/**
* @param seatNumber selection
* @param name of guest
*/
    public void reserveSeat(int seatNumber, String name) {
        seatList.get(seatNumber - 1).reserveFor(name);
    }
/**
* @param seatNumber canceled reserved seat 
*/
    public void cancelSeatReservation(int seatNumber) {
        seatList.get(seatNumber - 1).cancelReservation();
    }
/**
* @param seatNumber and assign to chosen seat
*/
    public void getPassengerName(int seatNumber) {
        String passengerName = seatList.get(seatNumber - 1).getAssignedName();
        System.out.println(passengerName + " is assigned to seat " + seatNumber);
    }
/**
* @param averageSpeed of aircraft
*/
    public void changeAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
/**
 * 
 * @return average speed of aircraft
 */
    public int getAverageSpeed() {
        return averageSpeed;
    }
 /**
 * sets the flight time 
 * @return time 
 */
    private String setFlightTime() {
        double flightTime = distance / averageSpeed;
        int hours = (int) flightTime;
        int minutes = (int) ((flightTime % 1) * 60);
        Random randomGenerator = new Random();
        int randomMinutes = randomGenerator.nextInt(5) + 1;
        minutes -= randomMinutes;
        if (minutes < 0) {
            minutes += 6;
        }
        String time = "";
        if (hours >= 2 && minutes > 1) {
            time = hours + " hrs " + minutes + " mins";
        } else if (hours >= 2 && minutes == 1) {
            time = hours + " hrs " + minutes + " min";
        } else if (hours >= 2 && minutes == 0) {
            time = hours + " hrs";
        } else if (hours == 1 && minutes > 1) {
            time = hours + " hr " + minutes + " mins";
        } else if (hours == 1 && minutes == 1) {
            time = hours + " hr " + minutes + " min";
        } else if (hours == 1 && minutes == 0) {
            time = hours + " hr";
        } else if (hours == 0 && minutes > 0) {
            time = minutes + " mins";
        }
        return time;
    }
/**
* @return time
*/
    public String getFlightTime() {
        return this.time;
    }
/**
 *  passes distance to the price calculator class and sets the price
 */
    private double setPrice() {
        PriceCalculator pricec = new PriceCalculator(distance);
        return pricec.getPrice();
    }
/**
* @return price
*/
    public double getPrice() {
        return price;
    }
/** 
* @param seatNumber chosen
* @return price up charge based on seat selection
*/
    public double getSeatUpcharge(int seatNumber) {
        PriceCalculator pricec = new PriceCalculator(seatList);
        return pricec.getSeatUpcharge(seatNumber);
    }
/**
 * @return distance
 */
    public double getDistance() {
        return distance;
    }
/**
 * @return flightIdentifier
 */   
    public String getIdentifier() {
        return flightIdentifier;
    }
 /**
 * @return name of source city
 */
    public String getSourceCity() {
        return source.getName();
    }
 /**
 * @return name of chosen destination city
 */
    public String getDestinationCity() {
        return destination.getName();
    }
/**
* prints flight info 
*/    
    public void getFlightInfo() {
        System.out.printf("Airliner: %-20s Flight Identifier: %-7s Price: %.2f USD    Open Seats: %-4d Time: %2s%n", this.airline, this.flightIdentifier, this.getPrice(), this.getTotalSeats(), this.getFlightTime());
    }
/**
* prints chosen flight class greeting
*/
    public void classGreeting(int seat) {
        this.getSeatList().get(seat - 1).classGreeting();
    }
}
