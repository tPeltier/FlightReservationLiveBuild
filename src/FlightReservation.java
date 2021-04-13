
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import java.util.Random;

public class FlightReservation {

    public static void main(String[] args) {
        
        //need help figuring out where to put .close() for the scanners without breaking everything...
        //closing scanners causes java.util.NoSuchElementException
        //--see link below---
        //https://stackoverflow.com/questions/13042008/java-util-nosuchelementexception-scanner-reading-user-input
        
        String repeat = "";

        do {
            //arraylist of city objects
            ArrayList<City> cities = new ArrayList<>();
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

            //prints array
            System.out.println("Cities flights are available from: ");
            System.out.println("==================================");
            for (int i = 0; i < 10; i++) {
                System.out.println("-->" + cities.get(i).getName() + "<--");
            }
            System.out.println("");
           
            //scanner obj
            Scanner in = new Scanner(System.in);
            //todo can currently fly from and to the same city
            
            InputCheck inputCheck = new InputCheck(cities);
            int cityDepartureIndex = inputCheck.getDepartureCityIndex();
            int cityArrivalIndex = inputCheck.getArrivalCityIndex();
            
            Flight chosenFlight = getFlight(cities, cityDepartureIndex, cityArrivalIndex);
            Ticket ticket1 = reserveSeat(chosenFlight);
            ticket1.print();

            String makeChanges = "";
            int selection = 0;
            //args will have to change if we make an array(list) of tickets
            TicketChanges changes = new TicketChanges(ticket1, chosenFlight, selection);
            if(changes.check().equalsIgnoreCase("y")) {
                
                do {

                    changes.print();
                    int userSelection = changes.getSelection();
                    changes.cases(ticket1, chosenFlight, userSelection);
                
                    
                    if(userSelection == 3){
                        
                        break;
                    }
                } while (changes.check().equalsIgnoreCase("y"));
                   
                
            }
            System.out.printf("%n Your final ticket: %n");
            ticket1.print();
            System.out.print("Would you like to book a new flight? (Y/N)");
            repeat = in.next();
            //in.close();
        } while (repeat.equalsIgnoreCase("y"));
        System.out.println("Thank you for flying with us!");
        //in.close();
        //closes scanner

            
    }//end main




    public static Flight getFlight(ArrayList<City> cities, int departureIndex, int arrivalIndex) {

        String airliners[] = {"Delta Airlines", "American Airlines", "Spirit Airlines", "United Airlines", "SouthWest", "JetBlue"};

        Random randomGenerator = new Random();

        System.out.println();
        System.out.println("---Available Flights---");
        //System.out.println();

        ArrayList<Flight> flights = new ArrayList<>();

        int randomFlights = randomGenerator.nextInt(8) + 3;
        int x = 0;

        while (randomFlights > x) {

            int random = randomGenerator.nextInt(5);
            int randomSeats = randomGenerator.nextInt(10) + 1;

            flights.add(new Flight(airliners[random], randomSeats, cities.get(departureIndex), cities.get(arrivalIndex)));

            flights.get(x).getFlightInfo();

            x++;
        }

        System.out.println();
        //TODO need input validation
        //todo O looks like 0 when printed
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the flight identifier of your chosen flight: ");
        String flightSelection = in.next();
        //in.close();
        int objectIndex = 0;
        while (objectIndex < flights.size()) {
            if (flights.get(objectIndex).getIdentifier().equalsIgnoreCase(flightSelection)) {
                break;
            }
            objectIndex++;
        }
        System.out.println("");
        //System.out.println("You chose flight " + flights.get(objectIndex).getIdentifier());


        return flights.get(objectIndex);
    }

    public static Ticket reserveSeat(Flight chosenFlight) {

        chosenFlight.getOpenSeats();
        //TODO need input validation 
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.print("Which seat would you like to reserve?");
        int seatSelection = in.nextInt();
        System.out.print("Who will be flying with us?");
        in.nextLine();
        String name = in.nextLine();
        chosenFlight.reserveSeat(seatSelection, name);
        //in.close();
        return new Ticket(chosenFlight.getSourceCity(), chosenFlight.getDestinationCity(), chosenFlight.getIdentifier(), seatSelection, name, chosenFlight.getPrice(), chosenFlight.getFlightTime(), chosenFlight.getSeatList().get(seatSelection - 1).getClassType(), chosenFlight.getSeatUpcharge(seatSelection));

    }


}



  
    
//     calls system info display to inform user before selections are made
//    public SystemInfoClass() {
//        call SystemInfoClass this.departureCity = in.nextLine();
//        display1 = new SystemInfoClass();
//        return display1;
//    }
//      
 
     
    

    




