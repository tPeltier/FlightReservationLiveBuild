import java.util.Scanner;

public class TicketChanges {
    private String makeChanges;
    private int changeSelection;

    Scanner in = new Scanner(System.in);
    public  void  changeLoop(Ticket ticket1,Flight chosenFlight){
        makeChanges = "";
        int selection = 0;
        check();
        //args will have to change if we make an array(list) of tickets
        if(makeChanges.trim().equalsIgnoreCase("y")) {
            do {

                print();
                int userSelection = getSelection();
                cases(ticket1, chosenFlight, userSelection);
                if (userSelection == 3) {
                    break;
                }
            } while (makeChanges.equalsIgnoreCase("y"));

        }
    }

	private String check(){
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


    public void cases(Ticket ticket1, Flight chosenFlight, int changeSelection){
        switch (changeSelection) {
            case 1 : {
                System.out.print("Enter a new name: ");
                String name = in.next();
                ticket1.setName(name);
                chosenFlight.reserveSeat(ticket1.getSeatNum(), name);
                System.out.println();
                System.out.println("Name has been successfully changed.");
                ticket1.print();
                break;
            }
            case 2 : {
                chosenFlight.cancelSeatReservation(ticket1.getSeatNum());
                chosenFlight.getOpenSeats();
                System.out.print("Enter a new seat number: ");
                int newSeat = in.nextInt();
                chosenFlight.reserveSeat(newSeat, ticket1.getName());
                //do we need another obj? 
                Ticket ticket2 = new Ticket(chosenFlight, newSeat, ticket1.getName());
                System.out.println();
                System.out.println("Seat has been successfully changed.");
                ticket2.print();
                break;
            }
            case 3 : {
                ticket1.cancelTicket();
                System.out.println("---Ticket canceled---");
                break;
            }
            default : System.out.println("No valid selection");
        }
    }

	public TicketChanges(Ticket ticket1, Flight chosenFlight){

    }
}

