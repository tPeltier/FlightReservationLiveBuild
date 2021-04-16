
import java.util.InputMismatchException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

class FlightManager {
    private int seatSelection;
    private City departure;
    private City arrival;
    private boolean validSeat = false;
    private boolean validInput = true;
    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<City> cityList = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public FlightManager() {

    }

    public void setDepartureCity(City departure) {
        this.departure = departure;
    }

    public void setArrivalCity(City arrival) {
        this.arrival = arrival;
    }

    public void createFlights() {
        Random randomGenerator = new Random();

        int randomFlightsToCreate = randomGenerator.nextInt(8) + 3;

        for (int i = 0; i < randomFlightsToCreate; i++) {

            flights.add(new Flight(departure, arrival));
            i++;

        }

    }

    public void displayFlights() {
        System.out.println();
        System.out.println("---Available Flights---");
        for (int i = 0; i < flights.size(); i++) {
            flights.get(i).getFlightInfo();
        }

    }

    public ArrayList<Flight> getFlightList() {
        return flights;
    }

    public Flight retrieveFlight() {

        Scanner in = new Scanner(System.in);

        boolean flightFound;
        String flightIdentifier;

            do {
                System.out.println();
                System.out.print("Enter the flight identifier of your chosen flight: ");
                flightIdentifier = in.next();
                flightFound = verifyFlightSelection(flightIdentifier);
                if(!flightFound)
                {
                    System.out.println("\nPlease check spelling and reenter the flight identifier.");
                }
            } while(!flightFound);

            int objectIndex = getVerifiedFlightSelection(flightIdentifier);

            return flights.get(objectIndex);

    }
    private boolean verifyFlightSelection(String flightIdentifier)
    {
        int objectIndex = 0;
        while (objectIndex < flights.size()) {
            if (flights.get(objectIndex).getIdentifier().equalsIgnoreCase(flightIdentifier)) {
                return true;

            }
            objectIndex++;
        }
        return false;

    }

    private int getVerifiedFlightSelection(String flightIdentifier)
    {
        int objectIndex = 0;
        while (objectIndex < flights.size()) {
            if (flights.get(objectIndex).getIdentifier().equalsIgnoreCase(flightIdentifier)) {
                break;
            }
            objectIndex++;
        }
            return objectIndex;
    }

    public void setSeatInput() {
        System.out.println();
        System.out.print("Which seat would you like to reserve?");
        if(in.hasNextInt()){
            seatSelection = in.nextInt();
            validInput = true;
        }
        else{
            System.out.println("Please enter a number");
            validInput = false;
        }

        in.nextLine();

    }
    public void retrySeatInput(){
        while (!validInput){
            setSeatInput();
        }
    }
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
                System.out.println("That is not a valid seat selection.");
                setSeatInput();
            }
        }
    }
    public int getSeatInput(){
        return seatSelection;
    }
    public String getNameInput()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Who will be flying with us?");
        String name = in.nextLine().trim();
        return name;
    }

}
