import java.util.Scanner;
/**
 * class that allows the customer to make changes to their ticket
 */
public class TicketUpdater {
    private String makeChanges;
    private int changeSelection;
    private Scanner in = new Scanner(System.in);
    private Ticket ticket;
    private Flight flight;
    FlightManager changeSeatObj = new FlightManager();
/**
* setters
* @param ticket1
* @param chosenFlight
*/
    public TicketUpdater(Ticket ticket1, Flight chosenFlight) {
        ticket = ticket1;
        flight = chosenFlight;
    }
 /**
 * takes in customers change selection
 * @param chosenFlight 
 */
    public  void  changeLoop(Flight chosenFlight){
        do {
            makeChanges = setMakeChanges();
            if(makeChanges.trim().equalsIgnoreCase("n")){
                break;
            }
            print();
            int userSelection = getSelection();
            if(userSelection == 1) {
                updateName();
            }
            else if (userSelection == 2) {
                changeSeat(chosenFlight);
            }
            else if (userSelection == 3) {
                cancelTicket();
                break;
            }
        } while(makeChanges.trim().equalsIgnoreCase("y"));
    }
/**
 * @return makeChanges
 */
    private String setMakeChanges(){
        System.out.print("Would you like to make any changes to your reservation? (Y/N)");
        makeChanges = in.next();
        return makeChanges;
    }
/**
* provides the user with the change options available
*/
    private void print(){
        System.out.printf("%nWhat would you like to change on your ticket?%n");
        System.out.println("---------------------------------------------");
        System.out.println("Press 1 to change the name on the ticket");
        System.out.println("Press 2 to change the reserved seat");
        System.out.println("Press 3 to cancel your ticket");
        System.out.println("---------------------------------------------");
    }
/**
* @return change selection
*/
    private int getSelection(){
        changeSelection = in.nextInt();
        System.out.println();
        return changeSelection;
    }
/**
* updates name on ticket
*/
    public void updateName() {
        System.out.println("Enter a new name: ");
        String name = in.next();
        ticket.setName(name);
        flight.reserveSeat(ticket.getSeatNum(), name);
        System.out.println();
        System.out.println("---Name has been successfully changed---");
        ticket.print();
    }
/**
* updates seat on ticket
*/
    public void changeSeat(Flight chosenFlight) {
        flight.cancelSeatReservation(ticket.getSeatNum());
        flight.getOpenSeats();
        changeSeatObj.setSeatInput();
        changeSeatObj.checkSeatInput(chosenFlight);
        int newSeat = changeSeatObj.getSeatInput();
        ticket.setSeatNum(newSeat);
        flight.reserveSeat(newSeat, ticket.getName());
        //do we need another obj?
        Ticket ticket2 = new Ticket(flight, newSeat, ticket.getName());
        System.out.println();
        System.out.println("---Seat has been successfully changed---");
        ticket2.print();
    }
/**
* cancels reservation
*/
    public void cancelTicket() {
        ticket.cancelTicket();
        System.out.println("---Ticket canceled---");
    }
}



