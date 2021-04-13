
import java.util.ArrayList;
import java.util.Scanner;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
public class FlightReservation {

    public static void main(String[] args) {

        //need help figuring out where to put .close() for the scanners without breaking everything...
        //closing scanners causes java.util.NoSuchElementException
        //--see link below---
        //https://stackoverflow.com/questions/13042008/java-util-nosuchelementexception-scanner-reading-user-input
        String repeat = "";

        do {
           
            FlightManager fm = new FlightManager();
            ArrayList<City> cities = fm.getFlightCityList();
            fm.displayFlightCities();
            
            //scanner obj
            Scanner in = new Scanner(System.in);
            
            //todo can currently fly from and to the same city
            InputCheck inputCheck = new InputCheck(cities);
        
            City departureCity = cities.get(inputCheck.getDepartureCityIndex());
            City arrivalCity = cities.get(inputCheck.getArrivalCityIndex());
            
            fm.setDepartureCity(departureCity);
            fm.setArrivalCity(arrivalCity);
           
            fm.createFlights();
            fm.displayFlights();
            Flight chosenFlight = fm.retrieveFlight();

            Ticket ticket1 = reserveSeat(chosenFlight, fm);
            ticket1.print();

            String makeChanges = "";
            int selection = 0;
            //args will have to change if we make an array(list) of tickets
            TicketChanges changes = new TicketChanges(ticket1, chosenFlight, selection);

            


            if(changes.check().trim().equalsIgnoreCase("y")) {
                

                do {

                    changes.print();
                    int userSelection = changes.getSelection();
                    changes.cases(ticket1, chosenFlight, userSelection);

                    if (userSelection == 3) {

                        break;
                    }
                    
                } while (changes.check().equalsIgnoreCase("y"));

            }
            System.out.printf("%n Your final ticket: %n");
            ticket1.print();
            System.out.print("Would you like to book a new flight? (Y/N)");
            repeat = in.next();
            //in.close();

      
        

        } while (repeat.trim().equalsIgnoreCase("y"));

        System.out.println("Thank you for flying with us!");
        //in.close();
        //closes scanner

        
    }//end main

    public static Ticket reserveSeat(Flight chosenFlight, FlightManager fm) {




   


        chosenFlight.getOpenSeats();
        //TODO need input validation / add in .trim() with that
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.print("Which seat would you like to reserve?");
        int seatSelection = in.nextInt();
        System.out.print("Who will be flying with us?");
        in.nextLine();
        String name = in.nextLine().trim();
        chosenFlight.reserveSeat(seatSelection, name);
        //in.close();
        return new Ticket(chosenFlight, seatSelection, name);

    }

}

//     calls system info display to inform user before selections are made
//    public SystemInfoClass() {
//        call SystemInfoClass this.departureCity = in.nextLine();
//        display1 = new SystemInfoClass();
//        return display1;
//    }
//      

