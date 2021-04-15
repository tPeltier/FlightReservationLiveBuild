
import java.util.Scanner;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
public class FlightReservation {

    public static void main(String[] args) {

        //todo replace missing print statements

        String repeat = "";
        do {
            Scanner in = new Scanner(System.in);

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

            //TODO need input validation
            flightManager.setSeatInput();
            flightManager.checkSeatInput(chosenFlight);

            int seatSelection = flightManager.getSeatInput();
            String name = flightManager.getNameInput();

            chosenFlight.reserveSeat(seatSelection, name);

            Ticket ticket = new Ticket(chosenFlight, seatSelection, name);

            //-------------------

            ticket.print();

            TicketUpdater ticketupdater = new TicketUpdater();

            ticketupdater.changeLoop(ticket, chosenFlight);

            System.out.printf("%n ---Your final ticket--- %n");
            ticket.print();
            System.out.print("Would you like to book a new flight? (Y/N)");
            repeat = in.next();
            //in.close();

        } while (repeat.trim().equalsIgnoreCase("y"));
        System.out.println("Thank you for flying with us!");
        //in.close();
        //closes scanner
    }//end main
}


