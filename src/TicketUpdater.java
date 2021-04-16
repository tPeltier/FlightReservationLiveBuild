import java.util.Scanner;

public class TicketUpdater {
    private String makeChanges;
    private int changeSelection;
    private Scanner in = new Scanner(System.in);
    private Ticket ticket;
    private Flight flight;

    public TicketUpdater(Ticket ticket1, Flight chosenFlight)
    {
        ticket = ticket1;
        flight = chosenFlight;
    }



    public  void  changeLoop(){
        do {
            makeChanges = setMakeChanges();
            if(makeChanges.trim().equalsIgnoreCase("n")){
                break;
            }
            print();
            int userSelection = getSelection();
            if(userSelection == 1)
            {
                updateName();
            }
            else if (userSelection == 2)
            {
                changeSeat();
            }
            else if (userSelection == 3) {
                cancelTicket();
                break;
            }
        } while(makeChanges.trim().equalsIgnoreCase("y"));
    }

    private String setMakeChanges(){
        System.out.print("Would you like to make any changes to your reservation? (Y/N)");
        makeChanges = in.next();
        return makeChanges;
    }
    private void print(){
        System.out.println("What would you like to change on your ticket?");
        System.out.println("Press 1 to change the name on the ticket");
        System.out.println("Press 2 to change the reserved seat");
        System.out.println("Press 3 to cancel your ticket");
    }
    private int getSelection(){
        //Scanner in = new Scanner(System.in);
        changeSelection = in.nextInt();
        System.out.print("Your selection:" + changeSelection);
        System.out.println();
        return changeSelection;
    }

    public void updateName()
    {
        System.out.print("Enter a new name: ");
        String name = in.next();
        ticket.setName(name);
        flight.reserveSeat(ticket.getSeatNum(), name);
        System.out.println();
        System.out.println("Name has been successfully changed.");
        ticket.print();
    }
    public void changeSeat()
    {
        flight.cancelSeatReservation(ticket.getSeatNum());
        flight.getOpenSeats();
        System.out.print("Enter a new seat number: ");
        int newSeat = in.nextInt();
        ticket.setSeatNum(newSeat);
        flight.reserveSeat(newSeat, ticket.getName());
        //do we need another obj?
        Ticket ticket2 = new Ticket(flight, newSeat, ticket.getName());
        System.out.println();
        System.out.println("Seat has been successfully changed.");
        ticket2.print();
    }
    public void cancelTicket()
    {
        ticket.cancelTicket();
        System.out.println("---Ticket canceled---");
    }
}



