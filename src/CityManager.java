
import java.util.ArrayList;
import java.util.Scanner;

public class CityManager {
    private String cityArrival;
    private String cityDeparture;
    private int departureCityIndex;
    private int arrivalCityIndex;
    private boolean validDeparture;
    private boolean foundDeparture;
    private boolean validArrival;
    private boolean foundArrival;
    ArrayList<City> cities = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public CityManager() {
        cities.add(new City("Atlanta", 33.748997, -84.387985));
        cities.add(new City("Los Angeles", 34.052235, -118.243683));
        cities.add(new City("Chicago", 41.878113, -87.629799));
        cities.add(new City("Dallas", 32.776665, -96.796989));
        cities.add(new City("Denver", 39.7392364, -104.9848623));
        cities.add(new City("New York City", 40.7127281, -74.0060152));
        cities.add(new City("San Francisco", 37.7790262, -122.4199061));
        cities.add(new City("Seattle", 47.6038321, -122.3300624));
        cities.add(new City("Las Vegas", 36.1672559, -115.1485163));
        cities.add(new City("Orlando", 28.5421109, -81.3790304));
    }
    public void runInputCheck() {
        DepartureInputCheck();
        ArrivalInputCheck();
        duplicateCityCheck();
    }
    private void setCityArrival() {
        System.out.println("Select a city from the list to arrive at:");
        cityArrival = in.nextLine();
    }
    private void setCityDeparture() {
        System.out.println("Select a city from the list to depart from:");
        cityDeparture = in.nextLine();
    }
    private void setCityDepartureIndex() {
        foundDeparture = false;
        int pos = 0;
        while (pos < cities.size() && !foundDeparture) {
            if (cities.get(pos).getName().equalsIgnoreCase(cityDeparture.trim())) {
                foundDeparture = true;
                departureCityIndex = pos; // for Bradley's class
            } else {
                pos++;
            }
        }
    }
    private void setCityArrivalIndex() {
        foundArrival = false;
        int pos = 0;
        while (pos < cities.size() && !foundArrival) {
            if (cities.get(pos).getName().equalsIgnoreCase(cityArrival.trim())) {
                foundArrival = true;
                arrivalCityIndex = pos; // for Bradley's class
            } else {
                pos++;
            }
        }
    }
    private void setValidDeparture() {
        if (foundDeparture) {
            validDeparture = true;
        } else {
            System.out.println("---Invalid arrival city---");
            System.out.println("---Please check spelling and make sure the city is on the list---");
            validDeparture = false;
        }
    }
    private void setValidArrival() {
        if (foundArrival) {
            validArrival = true;
        } else {
            System.out.println("---Invalid arrival city---");
            System.out.println("---Please check spelling and make sure the city is on the list---");
            validArrival = false;
        }
    }
    private void DepartureInputCheck() {
        while (!validDeparture) {
            setCityDeparture();
            setCityDepartureIndex();
            setValidDeparture();
        }
    }
    private void ArrivalInputCheck() {
        while (!validArrival) {
            setCityArrival();
            setCityArrivalIndex();
            setValidArrival();
        }
    }
    public int getDepartureCityIndex() {
        return departureCityIndex;
    }
    public int getArrivalCityIndex() {
        return arrivalCityIndex;
    }
    private void duplicateCityCheck() {
        boolean duplicateFound;
        do {
            if(departureCityIndex == arrivalCityIndex) {
                    duplicateFound = true;
                    validArrival = false; validDeparture = false;
                    System.out.println("---You can not have the same arrival and destination city---");
                    System.out.println("---Please enter a new city from the list---");
                    ArrivalInputCheck();
                }
            else {
                    duplicateFound = false;
                }
        } while(duplicateFound);
    }
    public void displayCities() {
        System.out.println("Cities flights are available from: ");
        System.out.println("==================================");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println("--> " + cities.get(i).getName() + " <--");
        }
        System.out.println("==================================");
    }
    public ArrayList<City> getCityList() {
        return cities;
    }
    public City getArrivalCity() {
        return cities.get(arrivalCityIndex);
    }
    public City getDepartureCity() {
        return cities.get(departureCityIndex);
    }
}
