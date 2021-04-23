/**
* introduction to the program class
*/
public class Introduction {
    public Introduction(){
        //empty
    }
 /**
 * print statemtns for user clarification
 */
    public void printTutorial(){
        System.out.printf("%nIn this intro, we will show you how to operate and navigate through our system, to successfully reserve a ticket.%n");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        pressEnterToContinue();
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.println("Step1: The system will show you a list of cities that you can depart from and arrive at. Just type in the city you wish to depart from on the list.");
        System.out.println("Step2: Just like in the first step, type in the city you wish to arrive at.");
        System.out.println("Step3: The system will show you a list of what flights are available, along with the number of open seats on the flight, the flight duration, and the price of the flight.");
        System.out.println("-----> Just type in the Flight Identifier to pick a flight. The Flight Identifier will be TWO LETTERS followed by TWO NUMBERS. Ex:SP20,DE40,etc.");
        System.out.println("Step4: The system will show you a list of the open seats on the flight, including the class of the seat and and where it is located.");
        System.out.println("-----> Just type in the number of the seat to reserve it.");
        System.out.println("Step5: The system will ask you for a name to put on the ticket.");
        System.out.println("Step6: The system will print out your ticket for you to view.");
        System.out.println("Step7: The system will ask if you if you would like to make any changes to your ticket. Select Y for Yes and N for No.");
        System.out.println("-----> If you select yes, you will be shown a list of things you can change on your ticket");
        System.out.println("-------> You can change your seat, the name on the ticket or cancel the ticket.");
        System.out.println("-----> If you select no, you will have successfully reserved your ticket!");
        System.out.println("-------> The system will print out a final ticket for you to view.");
        System.out.println("Finally the program will ask you if you would like to reserve another ticket.");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        pressEnterToContinue();
        System.out.println();
    }
 /**
 * allows the user to continue past the intro page
 */
    private void pressEnterToContinue(){
        System.out.printf("---Press enter to continue---%n");
        try{
            System.in.read();
        }
        catch (Exception e){

        }
    }
}
