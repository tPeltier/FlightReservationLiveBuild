import java.util.Scanner;

public class TicketUpdater {
    private String makeChanges;
    private int changeSelection;
    private Scanner in = new Scanner(System.in);
    private boolean validSeat = false;
    private boolean validInput = true;
    private int newSeat;
    private Ticket ticket;
    private Flight flight;

    public TicketUpdater(Ticket ticket1, Flight chosenFlight)
    {
        ticket = ticket1;
        flight = chosenFlight;
    }

    public  void  changeLoop(Flight chosenFlight){
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
                changeSeat(chosenFlight);
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
    public void changeSeat(Flight chosenFlight)
    {
        flight.cancelSeatReservation(ticket.getSeatNum());
        flight.getOpenSeats();
        System.out.print("Enter a new seat number: ");
        //int newSeat = in.nextInt();
        setSeatInput();
        checkSeatInput(chosenFlight);
        ticket.setSeatNum(newSeat);
        flight.reserveSeat(newSeat, ticket.getName());
        //do we need another obj?
        Ticket ticket2 = new Ticket(flight, newSeat, ticket.getName());
        System.out.println();
        System.out.println("Seat has been successfully changed.");
        ticket2.print();
    }
    public void setSeatInput() {
        System.out.println();

        if(in.hasNextInt()){
            newSeat = in.nextInt();
            validInput = true;
        }
        else{
            System.out.println("Please enter a number");
            validInput = false;
        }

        in.nextLine();

    }
    public void retrySeatInput(){
        while (!validInput){
            setSeatInput();
        }
    }
    public void checkSeatInput(Flight chosenFlight) {
        retrySeatInput();
        int totalSeats = chosenFlight.getTotalSeats();

        /*if everything is input correctly:
        validSeat = false(default) incoming
        validInput = true(since int) incoming
         */
        while (!validSeat) {
            retrySeatInput();
            if (newSeat <= totalSeats && newSeat > 0) {
                validSeat = true;
            } else if (newSeat > totalSeats || newSeat <= 0) {
                System.out.println("That is not a valid seat selection.");
                setSeatInput();
            }
        }
    }
    public void cancelTicket()
    {
        ticket.cancelTicket();
        System.out.println("---Ticket canceled---");
    }
}



