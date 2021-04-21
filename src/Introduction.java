public class Introduction {
    public Introduction(){
        //empty
    }
    public void printTutorial(){
        System.out.printf("%nIn this intro, we will show you how to operate and navigate through our system, to successfully reserve a ticket.%n");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        pressEnterToContinue();
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.println("1st, you will be asked to select a city that you are departing from. Just type the city you wish to depart from on the list.");
        System.out.println("2nd, you will be asked to select a city on which you will arrive at. Just like in the first step, type the city you wish to arrive at.");
        System.out.println("3rd, the system will show what flights are available, along with the amount of seats open, the amount of time the flight will take, and the price.");
        System.out.println("     Just type in the Flight Identifier. The Identifier will be two letters followed by two numbers. Ex:SP20,DE40,etc.");
        System.out.println("4th, you will select the seat you desire, along with the position of the seat within the plane. Just type in the number of the seat.");
        System.out.println("5th, you will be asked for who will be boarding the plane to reserve the ticket. ");
        System.out.println("6th, your ticket will show to you. ");
        System.out.println("7th, the program will ask if you would like to make any changes. Select Y for Yes and N for No.");
        System.out.println("     If you select yes, you will be asked with a list of what you would like to change.");
        System.out.println("     If you select no, you will have successfully reserved your ticket!");
        System.out.println("Finally the program will ask you if you would like to reserve another ticket.");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        pressEnterToContinue();
        System.out.println();
    }
    private void pressEnterToContinue(){
        System.out.printf("---Press enter to continue---%n");
        try{
            System.in.read();
        }
        catch (Exception e){

        }
    }
}
