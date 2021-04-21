
import java.util.InputMismatchException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * input checks for seat and flights
 */
class FlightManager {
    private int seatSelection;
    private City departure;
    private City arrival;
    private boolean validSeat = false;
    private boolean validInput = true;
    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<City> cityList = new ArrayList<>();
    Scanner in = new Scanner(System.in);
/**
 * constructor
 */
    public FlightManager() {
    }
/**
 * @param departure sets city
 */
    public void setDepartureCity(City departure) {
        this.departure = departure;
    }
/**
 * @param arrival sets city
 */
    public void setArrivalCity(City arrival) {
        this.arrival = arrival;
    }
/**
 * creates flights with a random generator
 */
    public void createFlights() {
        Random randomGenerator = new Random();
        int randomFlightsToCreate = randomGenerator.nextInt(8) + 3;
        for (int i = 0; i < randomFlightsToCreate; i++) {
            flights.add(new Flight(departure, arrival));
            i++;
        }
    }
/**
 * prints available flights
 */
    public void displayFlights() {
        System.out.println();
        System.out.println("------------------------------------------------Available Flights-------------------------------------------------");
        for (int i = 0; i < flights.size(); i++) {
            flights.get(i).getFlightInfo();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }
/**
 * @return flights from array list
 */
    public ArrayList<Flight> getFlightList() {
        return flights;
    }
/**
 * @return chosen flight
 */
    public Flight retrieveFlight() {
        Scanner in = new Scanner(System.in);
        boolean flightFound;
        String flightIdentifier;
            do {
                System.out.println("Enter the flight identifier of your chosen flight: ");
                flightIdentifier = in.next();
                flightFound = verifyFlightSelection(flightIdentifier);
                if(!flightFound) {
                    System.out.println("---Please check spelling and re-enter the flight identifier---");
                }
            } while(!flightFound);
            int objectIndex = getVerifiedFlightSelection(flightIdentifier);
            return flights.get(objectIndex);
    }
/**
* @param flightIdentifier
* @return boolean variable result 
*/
    private boolean verifyFlightSelection(String flightIdentifier) {
        int objectIndex = 0;
        while (objectIndex < flights.size()) {
            if (flights.get(objectIndex).getIdentifier().equalsIgnoreCase(flightIdentifier)) {
                return true;

            }
            objectIndex++;
        }
        return false;
    }
/**
 * @param flightIdentifier selection
 * @return objectIndex
 */
    private int getVerifiedFlightSelection(String flightIdentifier) {
        int objectIndex = 0;
        while (objectIndex < flights.size()) {
            if (flights.get(objectIndex).getIdentifier().equalsIgnoreCase(flightIdentifier)) {
                break;
            }
            objectIndex++;
        }
            return objectIndex;
    }
/**
 * set customer seat selection
 */
    public void setSeatInput() {
        System.out.println("Which seat would you like to reserve?");
        if(in.hasNextInt()){
            seatSelection = in.nextInt();
            validInput = true;
        }
        else{
            System.out.println("---Please enter a valid seat number---");
            validInput = false;
        }
        in.nextLine();
    }
/**
* allows customer to re-enter their selection
*/
    public void retrySeatInput(){
        while (!validInput){
            setSeatInput();
        }
    }
/** 
* @param chosenFlight selection
*/
    public void checkSeatInput(Flight chosenFlight) {
        retrySeatInput();
        int totalSeats = chosenFlight.getTotalSeats();

        /*if everything is input correctly:
        validSeat = false(default) incoming
        validInput = true(since int) incoming
         */
        while (!validSeat) {
            retrySeatInput();
            if (seatSelection <= totalSeats && seatSelection > 0) {
                validSeat = true;
            } else if (seatSelection > totalSeats || seatSelection <= 0) {
                System.out.println("---Please enter a valid seat number---");
                setSeatInput();
            }
        }
    }
/**
* @return seatSelection
*/
    public int getSeatInput(){
        return seatSelection;
    }
/**
* @return name of customer 
*/
    public String getNameInput() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("Who will be flying with us?");
        System.out.println("---------------------------");
        String name = in.nextLine().trim();
        return name;
    }

}
