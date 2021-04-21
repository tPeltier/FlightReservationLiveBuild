public class Introduction {

    public Introduction(){


    }

    public void printTutorial(){


        System.out.println("In this intro, we will show you how to operate and navigate through our system, to successfully reserve a ticket.");
        System.out.println("1st, you will be asked to select a city that you are departing from. Just type the city you wish to depart from on the list.");
        pressEnterToContinue();
        System.out.println("2nd, you will be asked to select a city on which you will arrive at. Just like in the first step, type the city you wish to arrive at.");
        pressEnterToContinue();
        System.out.println("3rd, the system will show what flights are available, along with the amount of seats open, the amount of time it will take, and the price.");
        pressEnterToContinue();
        System.out.println("For the 3rd step just type in the Flight Identifier. The Identifier will be two letters followed by two numbers. Ex:SP20,DE40,etc.");
        pressEnterToContinue();
        System.out.println("4th, you will select the seat class you desire, along with the position of the seat within the plane. Just type in the number of the seat and class you want.");
        pressEnterToContinue();
        System.out.println("5th, It will ask for who will be boarding the plane to reserve the ticket. ");
        pressEnterToContinue();
        System.out.println("6th, your ticket will appear with the the following credentials; 1. Name on Ticket: 2. Flight ID#: 3. Class Type: 4. Seat #: 5. Departure City: 6. Arrival City: 7. Flight Duration: 8. Tiket Price:. ");
        pressEnterToContinue();
        System.out.println("7th, the program will ask if you would like to make any changes. Select Y for Yes and N for No.");
        pressEnterToContinue();
        System.out.println("If selected Y or Yes, you will be asked with a list of what you would like to change. Ex: Press 1 to change name on ticket. Press 2 to change the reserved seat. Press 3 to cancel your ticket.");
        pressEnterToContinue();
        System.out.println("If selected N or No, you will have successfully reserved your ticket!");
        pressEnterToContinue();
        System.out.println();
    }
    private void pressEnterToContinue(){
        System.out.printf("%n---Press enter to continue---");
        try{
            System.in.read();
        }
        catch (Exception e){

        }
    }
}
