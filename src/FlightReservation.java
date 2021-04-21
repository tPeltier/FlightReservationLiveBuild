
import java.util.Scanner;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
public class FlightReservation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //todo replace missing print statements
        //todo make printlns printfs in some places(for spacing)

        System.out.println("Welcome to our ticket reservation system!");
        System.out.println("Would you like to view a tutorial on how to use the system? (Y/N) ");
        String viewTutorial = in.nextLine();
        Introduction intro = new Introduction();
        if(viewTutorial.trim().equalsIgnoreCase("y")){
            intro.printTutorial();
        }


        String repeat = "";
        do {


            FlightManager flightManager = new FlightManager();
            CityManager cityManager = new CityManager();

            cityManager.displayCities();

            cityManager.runInputCheck();

            City departureCity = cityManager.getDepartureCity();
            City arrivalCity = cityManager.getArrivalCity();
            
            flightManager.setDepartureCity(departureCity);
            flightManager.setArrivalCity(arrivalCity);
           
            flightManager.createFlights();
            flightManager.displayFlights();
            Flight chosenFlight = flightManager.retrieveFlight();

            chosenFlight.getOpenSeats();


            flightManager.setSeatInput();
            flightManager.checkSeatInput(chosenFlight);

            int seatSelection = flightManager.getSeatInput();
            String name = flightManager.getNameInput();

            chosenFlight.reserveSeat(seatSelection, name);

            Ticket ticket = new Ticket(chosenFlight, seatSelection, name);


            ticket.print();

            TicketUpdater ticketupdater = new TicketUpdater(ticket, chosenFlight);
            //todo no seat validation
            ticketupdater.changeLoop(chosenFlight);

            System.out.printf("%n ---Your final ticket--- %n");
            ticket.print();
            chosenFlight.classGreeting(flightManager.getSeatInput());
            System.out.print("Would you like to book a new flight? (Y/N)");
            repeat = in.next();
            //in.close();

        } while (repeat.trim().equalsIgnoreCase("y"));
        System.out.println("Thank you for flying with us!");
        System.out.println("Stay safe!");
        System.out.println("Remember to wear a mask and practice social distancing while flying.");
        //just to update commit lol

        //in.close();
        //closes scanner
    }//end main
}


