
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

class FlightManager {

    private City departure;
    private City arrival;
    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<City> cityList = new ArrayList<>();


    public FlightManager() {
        cityList.add(new City("Atlanta", 33.748997, -84.387985));
        cityList.add(new City("Los Angeles", 34.052235, -118.243683));
        cityList.add(new City("Chicago", 41.878113, -87.629799));
        cityList.add(new City("Dallas", 32.776665, -96.796989));
        cityList.add(new City("Denver", 39.7392364, -104.9848623));
        cityList.add(new City("New York City", 40.7127281, -74.0060152));
        cityList.add(new City("San Francisco", 37.7790262, -122.4199061));
        cityList.add(new City("Seattle", 47.6038321, -122.3300624));
        cityList.add(new City("Las Vegas", 36.1672559, -115.1485163));
        cityList.add(new City("Orlando", 28.5421109, -81.3790304));
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

    public void displayFlightCities() {
        System.out.println("Cities flights are available from: ");
        System.out.println("==================================");
        for (int i = 0; i < cityList.size(); i++) {
            System.out.println("-->" + cityList.get(i).getName() + "<--");
        }
        System.out.println();
    }
    
    public ArrayList<City> getFlightCityList()
    {
        return cityList;
    }
}
