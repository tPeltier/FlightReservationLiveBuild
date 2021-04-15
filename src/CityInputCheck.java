
import java.util.ArrayList;
import java.util.Scanner;

public class CityInputCheck {

    private String cityArrival;
    private String cityDeparture;
    private int departureCityIndex;
    private int arrivalCityIndex;
    private boolean validDeparture;
    private boolean foundDeparture;
    private boolean validArrival;
    private boolean foundArrival;
    ArrayList<City> cities;

    Scanner in = new Scanner(System.in);



    public CityInputCheck(ArrayList<City> cities) {
        this.cities = cities;
    }

    public void runInputCheck() {
        DepartureInputCheck();
        ArrivalInputCheck();
        duplicateCityCheck();
    }


    private void setCityArrival() {
        System.out.print("Select a city from the list to arrive at:");
        cityArrival = in.nextLine();
    }

    private void setCityDeparture() {
        System.out.print("Select a city from the list to depart from:");
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
            System.out.println("Invalid arrival city. Please check spelling and make sure the city is on the list.");
            validDeparture = false;
        }
    }

    private void setValidArrival() {

        if (foundArrival) {
            validArrival = true;
        } else {
            System.out.println("Invalid arrival city. Please check spelling and make sure the city is on the list.");
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
        do
        {
            if(departureCityIndex == arrivalCityIndex)
                {
                    duplicateFound = true;
                    validArrival = false; validDeparture = false;
                    System.out.println("You can not have the same arrival and destination city.");
                    System.out.println("Please enter new cities from the list.");
                    ArrivalInputCheck();

                }
            else
                {
                    duplicateFound = false;
                }
        } while(duplicateFound);
    }
}
