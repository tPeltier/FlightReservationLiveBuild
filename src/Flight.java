
import java.util.ArrayList;
import java.util.Random;

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

    public Flight(City source, City destination) {
        this.source = source;
        this.destination = destination;
        this.flightIdentifier = createFlightIdentifier();
        createSeats();
        this.distance = calculateDistance();
        this.time = setFlightTime();
        this.price = setPrice();
    }
    public String getAirliner() {
        return airline;
    }
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
    public int getTotalSeats() {
        return this.numberOfSeats;
    }
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
    private double calculateDistance() {
        DistanceCalculator disCalc = new DistanceCalculator();
        double distance = disCalc.calculateDistance(source, destination);
        return distance;
    }
    public ArrayList<FlightSeat> getSeatList() { // method to get a flight's list of seats for your classes (if it were to be needed)
        return seatList;
    }
    public void reserveSeat(int seatNumber, String name) {
        seatList.get(seatNumber - 1).reserveFor(name);
    }
    public void cancelSeatReservation(int seatNumber) {
        seatList.get(seatNumber - 1).cancelReservation();
    }
    public void getPassengerName(int seatNumber) {
        String passengerName = seatList.get(seatNumber - 1).getAssignedName();
        System.out.println(passengerName + " is assigned to seat " + seatNumber);
    }
    public void changeAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
    public int getAverageSpeed() {
        return averageSpeed;
    }
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
    public String getFlightTime() {
        return this.time;
    }
    private double setPrice() {
        PriceCalculator pricec = new PriceCalculator(distance);
        return pricec.getPrice();
    }
    public double getPrice() {
        return price;
    }
    public double getSeatUpcharge(int seatNumber) {
        PriceCalculator pricec = new PriceCalculator(seatList);
        return pricec.getSeatUpcharge(seatNumber);
    }
    public double getDistance() {
        return distance;
    }
    public String getIdentifier() {
        return flightIdentifier;
    }
    public String getSourceCity() {
        return source.getName();
    }
    public String getDestinationCity() {
        return destination.getName();
    }
    public void getFlightInfo() {
        System.out.printf("Airliner: %-20s Flight Identifier: %-7s Price: %.2f USD    Open Seats: %-4d Time: %2s%n", this.airline, this.flightIdentifier, this.getPrice(), this.getTotalSeats(), this.getFlightTime());
    }
    public void classGreeting(int seat) {
        this.getSeatList().get(seat - 1).classGreeting();
    }
}
