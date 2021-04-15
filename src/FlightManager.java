
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

class FlightManager {

    private City departure;
    private City arrival;
    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<City> cityList = new ArrayList<>();


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

    public int getSeatInput()
    {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.print("Which seat would you like to reserve?");
        int seatSelection = in.nextInt();
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
