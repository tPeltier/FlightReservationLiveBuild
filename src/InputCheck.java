import java.util.ArrayList;
import java.util.Scanner;

public class InputCheck {
	private String city;
	private int departureCityIndex = 0;
	private int arrivalCityIndex = 0;
	private boolean validDepature = false;
	private boolean validArrival = false;


	public InputCheck(ArrayList<City> cities){

	    Scanner in = new Scanner(System.in);
        //for departure
        while(!validDepature){

            System.out.print("Select a city from the list to depart from:");
            city = in.nextLine();

            //input validation
            int pos = 0;
            boolean found = false;
            while (pos < cities.size() && !found) {
                if (cities.get(pos).getName().equalsIgnoreCase(city.trim())) {
                    found = true;
                    departureCityIndex = pos; // for Bradley's class
                } else {
                    pos++;
                }

            }
            if (found) {
                validDepature = true;
            } else {
                System.out.println("Invalid arrival city. Please check spelling and make sure the city is on the list.");
            }
        } // End of loop
        //for arrival
        while(!validArrival){

            System.out.print("Select a city from the list to arrive at:");
            city = in.nextLine();

            //input validation
            int pos = 0;
            boolean found = false;
            while (pos < cities.size() && !found) {
                if (cities.get(pos).getName().equalsIgnoreCase(city.trim())) {
                    found = true;
                    arrivalCityIndex = pos; // for Bradley's class
                } else {
                    pos++;
                }

            }
            if (found) {
                validArrival = true;
            } else {
                System.out.println("Invalid arrival city. Please check spelling and make sure the city is on the list.");
            }
        } // End of loop
    }


	public int getDepartureCityIndex(){
		return departureCityIndex;
	}
	public int getArrivalCityIndex(){
		return arrivalCityIndex;
	}
}
